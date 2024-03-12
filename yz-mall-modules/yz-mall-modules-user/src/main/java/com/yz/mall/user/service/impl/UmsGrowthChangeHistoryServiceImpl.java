package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsGrowthChangeHistory;
import com.yz.mall.user.mapper.UmsGrowthChangeHistoryMapper;
import com.yz.mall.user.service.UmsGrowthChangeHistoryService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 成长值变化历史记录表(UmsGrowthChangeHistory)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:44
 */
@RequiredArgsConstructor
@Service("umsGrowthChangeHistoryService")
public class UmsGrowthChangeHistoryServiceImpl implements UmsGrowthChangeHistoryService {

    private final UmsGrowthChangeHistoryMapper baseMapper;


    @Override
    public TableDataInfo<UmsGrowthChangeHistory> listPage(UmsGrowthChangeHistory umsGrowthChangeHistory, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsGrowthChangeHistory> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsGrowthChangeHistory> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsGrowthChangeHistory getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsGrowthChangeHistory umsGrowthChangeHistory) {
        return baseMapper.insert(umsGrowthChangeHistory);
    }

    @Override
    public int edit(UmsGrowthChangeHistory umsGrowthChangeHistory) {
        return baseMapper.updateById(umsGrowthChangeHistory);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

