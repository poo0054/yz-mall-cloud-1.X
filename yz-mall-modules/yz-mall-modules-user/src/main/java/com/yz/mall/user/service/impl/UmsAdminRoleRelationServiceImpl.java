package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsAdminRoleRelation;
import com.yz.mall.user.domain.UmsRole;
import com.yz.mall.user.mapper.UmsAdminRoleRelationMapper;
import com.yz.mall.user.service.UmsAdminRoleRelationService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:43
 */
@RequiredArgsConstructor
@Service("umsAdminRoleRelationService")
public class UmsAdminRoleRelationServiceImpl implements UmsAdminRoleRelationService {

    private final UmsAdminRoleRelationMapper baseMapper;


    @Override
    public TableDataInfo<UmsAdminRoleRelation> listPage(UmsAdminRoleRelation umsAdminRoleRelation, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsAdminRoleRelation> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsAdminRoleRelation> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsAdminRoleRelation getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsAdminRoleRelation umsAdminRoleRelation) {
        return baseMapper.insert(umsAdminRoleRelation);
    }

    @Override
    public int edit(UmsAdminRoleRelation umsAdminRoleRelation) {
        return baseMapper.updateById(umsAdminRoleRelation);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return baseMapper.getRoleList(adminId);
    }
}

