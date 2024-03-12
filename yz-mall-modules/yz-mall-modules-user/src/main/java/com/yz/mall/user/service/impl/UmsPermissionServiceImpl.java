package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsPermission;
import com.yz.mall.user.mapper.UmsPermissionMapper;
import com.yz.mall.user.service.UmsPermissionService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台用户权限表(UmsPermission)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:02
 */
@RequiredArgsConstructor
@Service("umsPermissionService")
public class UmsPermissionServiceImpl implements UmsPermissionService {

    private final UmsPermissionMapper baseMapper;


    @Override
    public TableDataInfo<UmsPermission> listPage(UmsPermission umsPermission, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsPermission> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsPermission> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsPermission getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsPermission umsPermission) {
        return baseMapper.insert(umsPermission);
    }

    @Override
    public int edit(UmsPermission umsPermission) {
        return baseMapper.updateById(umsPermission);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

