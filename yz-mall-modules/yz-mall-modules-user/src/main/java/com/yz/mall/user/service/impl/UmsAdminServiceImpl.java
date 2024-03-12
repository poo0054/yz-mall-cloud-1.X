package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.api.auth.RemoteAuthService;
import com.yz.mall.api.auth.domain.Oauth2TokenDto;
import com.yz.mall.common.core.constant.AuthConstant;
import com.yz.mall.common.core.domain.UserDto;
import com.yz.mall.common.core.exception.Asserts;
import com.yz.mall.common.core.util.SpringUtils;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.api.ResultCode;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsAdmin;
import com.yz.mall.user.domain.UmsAdminLoginLog;
import com.yz.mall.user.domain.UmsRole;
import com.yz.mall.user.domain.query.UmsAdminQuery;
import com.yz.mall.user.mapper.UmsAdminLoginLogMapper;
import com.yz.mall.user.mapper.UmsAdminMapper;
import com.yz.mall.user.service.UmsAdminCacheService;
import com.yz.mall.user.service.UmsAdminRoleRelationService;
import com.yz.mall.user.service.UmsAdminService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;

/**
 * 后台用户表(UmsAdmin)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:39
 */
@RequiredArgsConstructor
@Service("umsAdminService")
public class UmsAdminServiceImpl implements UmsAdminService {

    private final UmsAdminMapper baseMapper;

    private final RemoteAuthService authService;

    private final UmsAdminLoginLogMapper loginLogMapper;

    private final UmsAdminRoleRelationService adminRoleRelationSereService;

    private final HttpServletRequest request;


    @Override
    public TableDataInfo<UmsAdmin> listPage(UmsAdmin umsAdmin, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsAdmin> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsAdmin> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsAdmin getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsAdmin umsAdmin) {
        return baseMapper.insert(umsAdmin);
    }

    @Override
    public int edit(UmsAdmin umsAdmin) {
        return baseMapper.updateById(umsAdmin);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }

    @Override
    public CommonResult<Oauth2TokenDto> login(String username, String password) {
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            Asserts.fail("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret", "123456");
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        CommonResult<Oauth2TokenDto> restResult = authService.getAccessToken(params);
        if (ResultCode.SUCCESS.getCode() == restResult.getCode() && restResult.getData() != null) {
            insertLoginLog(username);
        }
        return restResult;
    }

    /**
     * 添加登录记录
     *
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if (admin == null) {
            return;
        }
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        final LambdaQueryWrapper<UmsAdmin> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(UmsAdmin::getUsername, username);
        return baseMapper.selectOne(lambdaQuery);
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        //获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsRole> roleList = getRoleList(admin.getId());
            UserDto userDTO = new UserDto();
            BeanUtils.copyProperties(admin, userDTO);
            if (CollUtil.isNotEmpty(roleList)) {
                List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDTO.setRoles(roleStrList);
            }
            return userDTO;
        }
        return null;
    }

    @Override
    public UmsAdmin getCurrentAdmin() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if (StrUtil.isEmpty(userStr)) {
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        UmsAdmin admin = getCacheService().getAdmin(userDto.getId());
        if (admin == null) {
            admin = baseMapper.selectById(userDto.getId());
            getCacheService().setAdmin(admin);
        }
        return admin;
    }


    @Override
    public UmsAdminCacheService getCacheService() {
        return SpringUtils.getBean(UmsAdminCacheService.class);
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationSereService.getRoleList(adminId);
    }

    @Override
    public UmsAdmin register(UmsAdminQuery umsAdminQuery) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminQuery, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        final LambdaQueryWrapper<UmsAdmin> queryWrapper = Wrappers.<UmsAdmin>lambdaQuery()
                .eq(UmsAdmin::getUsername, umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = baseMapper.selectList(queryWrapper);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        baseMapper.insert(umsAdmin);
        return umsAdmin;
    }
}

