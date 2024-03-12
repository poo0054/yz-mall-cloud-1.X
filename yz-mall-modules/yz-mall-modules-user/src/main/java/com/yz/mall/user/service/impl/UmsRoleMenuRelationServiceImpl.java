package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsRoleMenuRelation;
import com.yz.mall.user.mapper.UmsRoleMenuRelationMapper;
import com.yz.mall.user.service.UmsRoleMenuRelationService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台角色菜单关系表(UmsRoleMenuRelation)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:07
 */
@RequiredArgsConstructor
@Service("umsRoleMenuRelationService")
public class UmsRoleMenuRelationServiceImpl implements UmsRoleMenuRelationService {

    private final UmsRoleMenuRelationMapper baseMapper;


    @Override
    public TableDataInfo<UmsRoleMenuRelation> listPage(UmsRoleMenuRelation umsRoleMenuRelation, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsRoleMenuRelation> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsRoleMenuRelation> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsRoleMenuRelation getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsRoleMenuRelation umsRoleMenuRelation) {
        return baseMapper.insert(umsRoleMenuRelation);
    }

    @Override
    public int edit(UmsRoleMenuRelation umsRoleMenuRelation) {
        return baseMapper.updateById(umsRoleMenuRelation);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

