package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsRoleResourceRelation;
import com.yz.mall.user.mapper.UmsRoleResourceRelationMapper;
import com.yz.mall.user.service.UmsRoleResourceRelationService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:09
 */
@RequiredArgsConstructor
@Service("umsRoleResourceRelationService")
public class UmsRoleResourceRelationServiceImpl implements UmsRoleResourceRelationService {

    private final UmsRoleResourceRelationMapper baseMapper;


    @Override
    public TableDataInfo<UmsRoleResourceRelation> listPage(UmsRoleResourceRelation umsRoleResourceRelation, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsRoleResourceRelation> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsRoleResourceRelation> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsRoleResourceRelation getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsRoleResourceRelation umsRoleResourceRelation) {
        return baseMapper.insert(umsRoleResourceRelation);
    }

    @Override
    public int edit(UmsRoleResourceRelation umsRoleResourceRelation) {
        return baseMapper.updateById(umsRoleResourceRelation);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

