package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMemberProductCategoryRelation;
import com.yz.mall.user.mapper.UmsMemberProductCategoryRelationMapper;
import com.yz.mall.user.service.UmsMemberProductCategoryRelationService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员与产品分类关系表（用户喜欢的分类）(UmsMemberProductCategoryRelation)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:53
 */
@RequiredArgsConstructor
@Service("umsMemberProductCategoryRelationService")
public class UmsMemberProductCategoryRelationServiceImpl implements UmsMemberProductCategoryRelationService {

    private final UmsMemberProductCategoryRelationMapper baseMapper;


    @Override
    public TableDataInfo<UmsMemberProductCategoryRelation> listPage(UmsMemberProductCategoryRelation umsMemberProductCategoryRelation, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsMemberProductCategoryRelation> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsMemberProductCategoryRelation> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsMemberProductCategoryRelation getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsMemberProductCategoryRelation umsMemberProductCategoryRelation) {
        return baseMapper.insert(umsMemberProductCategoryRelation);
    }

    @Override
    public int edit(UmsMemberProductCategoryRelation umsMemberProductCategoryRelation) {
        return baseMapper.updateById(umsMemberProductCategoryRelation);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

