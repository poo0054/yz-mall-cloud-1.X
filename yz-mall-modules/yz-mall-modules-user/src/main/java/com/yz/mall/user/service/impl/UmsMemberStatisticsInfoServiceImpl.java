package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMemberStatisticsInfo;
import com.yz.mall.user.mapper.UmsMemberStatisticsInfoMapper;
import com.yz.mall.user.service.UmsMemberStatisticsInfoService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员统计信息(UmsMemberStatisticsInfo)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:57
 */
@RequiredArgsConstructor
@Service("umsMemberStatisticsInfoService")
public class UmsMemberStatisticsInfoServiceImpl implements UmsMemberStatisticsInfoService {

    private final UmsMemberStatisticsInfoMapper baseMapper;


    @Override
    public TableDataInfo<UmsMemberStatisticsInfo> listPage(UmsMemberStatisticsInfo umsMemberStatisticsInfo, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsMemberStatisticsInfo> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsMemberStatisticsInfo> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsMemberStatisticsInfo getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return baseMapper.insert(umsMemberStatisticsInfo);
    }

    @Override
    public int edit(UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return baseMapper.updateById(umsMemberStatisticsInfo);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

