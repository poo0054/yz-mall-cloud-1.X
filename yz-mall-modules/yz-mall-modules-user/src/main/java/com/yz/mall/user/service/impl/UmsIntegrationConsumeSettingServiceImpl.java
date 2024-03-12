package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsIntegrationConsumeSetting;
import com.yz.mall.user.mapper.UmsIntegrationConsumeSettingMapper;
import com.yz.mall.user.service.UmsIntegrationConsumeSettingService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 积分消费设置(UmsIntegrationConsumeSetting)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:47
 */
@RequiredArgsConstructor
@Service("umsIntegrationConsumeSettingService")
public class UmsIntegrationConsumeSettingServiceImpl implements UmsIntegrationConsumeSettingService {

    private final UmsIntegrationConsumeSettingMapper baseMapper;


    @Override
    public TableDataInfo<UmsIntegrationConsumeSetting> listPage(UmsIntegrationConsumeSetting umsIntegrationConsumeSetting, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsIntegrationConsumeSetting> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsIntegrationConsumeSetting> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsIntegrationConsumeSetting getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsIntegrationConsumeSetting umsIntegrationConsumeSetting) {
        return baseMapper.insert(umsIntegrationConsumeSetting);
    }

    @Override
    public int edit(UmsIntegrationConsumeSetting umsIntegrationConsumeSetting) {
        return baseMapper.updateById(umsIntegrationConsumeSetting);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

