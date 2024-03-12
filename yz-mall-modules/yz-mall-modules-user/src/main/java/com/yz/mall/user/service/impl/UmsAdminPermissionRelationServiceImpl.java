package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsAdminPermissionRelation;
import com.yz.mall.user.mapper.UmsAdminPermissionRelationMapper;
import com.yz.mall.user.service.UmsAdminPermissionRelationService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:42
 */
@RequiredArgsConstructor
@Service("umsAdminPermissionRelationService")
public class UmsAdminPermissionRelationServiceImpl implements UmsAdminPermissionRelationService {

    private final UmsAdminPermissionRelationMapper baseMapper;


    @Override
    public TableDataInfo<UmsAdminPermissionRelation> listPage(UmsAdminPermissionRelation umsAdminPermissionRelation, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsAdminPermissionRelation> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsAdminPermissionRelation> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsAdminPermissionRelation getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsAdminPermissionRelation umsAdminPermissionRelation) {
        return baseMapper.insert(umsAdminPermissionRelation);
    }

    @Override
    public int edit(UmsAdminPermissionRelation umsAdminPermissionRelation) {
        return baseMapper.updateById(umsAdminPermissionRelation);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

