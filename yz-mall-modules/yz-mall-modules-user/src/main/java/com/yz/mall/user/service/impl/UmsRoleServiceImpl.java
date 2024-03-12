package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMenu;
import com.yz.mall.user.domain.UmsRole;
import com.yz.mall.user.mapper.UmsRoleMapper;
import com.yz.mall.user.service.UmsRoleService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台用户角色表(UmsRole)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:05
 */
@RequiredArgsConstructor
@Service("umsRoleService")
public class UmsRoleServiceImpl implements UmsRoleService {

    private final UmsRoleMapper baseMapper;


    @Override
    public TableDataInfo<UmsRole> listPage(UmsRole umsRole, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsRole> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsRole> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsRole getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsRole umsRole) {
        return baseMapper.insert(umsRole);
    }

    @Override
    public int edit(UmsRole umsRole) {
        return baseMapper.updateById(umsRole);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return baseMapper.getMenuList(adminId);
    }
}

