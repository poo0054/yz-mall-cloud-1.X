package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsIntegrationChangeHistory;
import com.yz.mall.user.mapper.UmsIntegrationChangeHistoryMapper;
import com.yz.mall.user.service.UmsIntegrationChangeHistoryService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 积分变化历史记录表(UmsIntegrationChangeHistory)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:46
 */
@RequiredArgsConstructor
@Service("umsIntegrationChangeHistoryService")
public class UmsIntegrationChangeHistoryServiceImpl implements UmsIntegrationChangeHistoryService {

    private final UmsIntegrationChangeHistoryMapper baseMapper;


    @Override
    public TableDataInfo<UmsIntegrationChangeHistory> listPage(UmsIntegrationChangeHistory umsIntegrationChangeHistory, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsIntegrationChangeHistory> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsIntegrationChangeHistory> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsIntegrationChangeHistory getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        return baseMapper.insert(umsIntegrationChangeHistory);
    }

    @Override
    public int edit(UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        return baseMapper.updateById(umsIntegrationChangeHistory);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

