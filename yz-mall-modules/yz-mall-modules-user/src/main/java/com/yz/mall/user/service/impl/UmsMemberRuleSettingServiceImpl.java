package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMemberRuleSetting;
import com.yz.mall.user.mapper.UmsMemberRuleSettingMapper;
import com.yz.mall.user.service.UmsMemberRuleSettingService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员积分成长规则表(UmsMemberRuleSetting)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:56
 */
@RequiredArgsConstructor
@Service("umsMemberRuleSettingService")
public class UmsMemberRuleSettingServiceImpl implements UmsMemberRuleSettingService {

    private final UmsMemberRuleSettingMapper baseMapper;


    @Override
    public TableDataInfo<UmsMemberRuleSetting> listPage(UmsMemberRuleSetting umsMemberRuleSetting, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsMemberRuleSetting> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsMemberRuleSetting> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsMemberRuleSetting getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsMemberRuleSetting umsMemberRuleSetting) {
        return baseMapper.insert(umsMemberRuleSetting);
    }

    @Override
    public int edit(UmsMemberRuleSetting umsMemberRuleSetting) {
        return baseMapper.updateById(umsMemberRuleSetting);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

