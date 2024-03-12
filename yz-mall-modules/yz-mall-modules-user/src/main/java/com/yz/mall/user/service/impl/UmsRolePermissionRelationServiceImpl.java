package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsRolePermissionRelation;
import com.yz.mall.user.mapper.UmsRolePermissionRelationMapper;
import com.yz.mall.user.service.UmsRolePermissionRelationService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台用户角色和权限关系表(UmsRolePermissionRelation)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:08
 */
@RequiredArgsConstructor
@Service("umsRolePermissionRelationService")
public class UmsRolePermissionRelationServiceImpl implements UmsRolePermissionRelationService {

    private final UmsRolePermissionRelationMapper baseMapper;


    @Override
    public TableDataInfo<UmsRolePermissionRelation> listPage(UmsRolePermissionRelation umsRolePermissionRelation, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsRolePermissionRelation> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsRolePermissionRelation> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsRolePermissionRelation getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsRolePermissionRelation umsRolePermissionRelation) {
        return baseMapper.insert(umsRolePermissionRelation);
    }

    @Override
    public int edit(UmsRolePermissionRelation umsRolePermissionRelation) {
        return baseMapper.updateById(umsRolePermissionRelation);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

