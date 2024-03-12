package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsResourceCategory;
import com.yz.mall.user.mapper.UmsResourceCategoryMapper;
import com.yz.mall.user.service.UmsResourceCategoryService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 资源分类表(UmsResourceCategory)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:05
 */
@RequiredArgsConstructor
@Service("umsResourceCategoryService")
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {

    private final UmsResourceCategoryMapper baseMapper;


    @Override
    public TableDataInfo<UmsResourceCategory> listPage(UmsResourceCategory umsResourceCategory, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsResourceCategory> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsResourceCategory> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsResourceCategory getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsResourceCategory umsResourceCategory) {
        return baseMapper.insert(umsResourceCategory);
    }

    @Override
    public int edit(UmsResourceCategory umsResourceCategory) {
        return baseMapper.updateById(umsResourceCategory);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

