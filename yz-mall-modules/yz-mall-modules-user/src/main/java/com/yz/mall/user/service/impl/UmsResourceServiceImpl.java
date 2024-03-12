package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.core.constant.AuthConstant;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.common.redis.utils.RedisUtils;
import com.yz.mall.user.domain.UmsResource;
import com.yz.mall.user.domain.UmsRole;
import com.yz.mall.user.domain.UmsRoleResourceRelation;
import com.yz.mall.user.mapper.UmsResourceMapper;
import com.yz.mall.user.mapper.UmsRoleMapper;
import com.yz.mall.user.mapper.UmsRoleResourceRelationMapper;
import com.yz.mall.user.service.UmsResourceService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;

/**
 * 后台资源表(UmsResource)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:03
 */
@RequiredArgsConstructor
@Service("umsResourceService")
public class UmsResourceServiceImpl implements UmsResourceService {

    private final UmsResourceMapper baseMapper;

    private final UmsRoleMapper roleMapper;

    private final UmsRoleResourceRelationMapper roleResourceRelationMapper;

    @PostConstruct
    public void init() {
        initResourceRolesMap();
    }


    @Override
    public TableDataInfo<UmsResource> listPage(UmsResource umsResource, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsResource> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsResource> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsResource getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsResource umsResource) {
        return baseMapper.insert(umsResource);
    }

    @Override
    public int edit(UmsResource umsResource) {
        return baseMapper.updateById(umsResource);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }

    @Override
    public Map<String, List<String>> initResourceRolesMap() {
        Map<String, List<String>> resourceRoleMap = new TreeMap<>();
        final List<UmsResource> resourceList = baseMapper.selectList();
        final List<UmsRole> roleList = roleMapper.selectList();
        final List<UmsRoleResourceRelation> relationList = roleResourceRelationMapper.selectList();
        for (UmsResource resource : resourceList) {
            Set<Long> roleIds = relationList.stream().filter(item -> item.getResourceId().equals(resource.getId())).map(UmsRoleResourceRelation::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = roleList.stream().filter(item -> roleIds.contains(item.getId())).map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            resourceRoleMap.put("/" + "mall-admin" + resource.getUrl(), roleNames);
        }
        RedisUtils.deleteObject(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        RedisUtils.setCacheMap(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
        return resourceRoleMap;
    }
}

