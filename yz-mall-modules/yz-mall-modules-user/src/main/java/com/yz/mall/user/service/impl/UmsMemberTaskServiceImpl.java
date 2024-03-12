package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMemberTask;
import com.yz.mall.user.mapper.UmsMemberTaskMapper;
import com.yz.mall.user.service.UmsMemberTaskService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员任务表(UmsMemberTask)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:00
 */
@RequiredArgsConstructor
@Service("umsMemberTaskService")
public class UmsMemberTaskServiceImpl implements UmsMemberTaskService {

    private final UmsMemberTaskMapper baseMapper;


    @Override
    public TableDataInfo<UmsMemberTask> listPage(UmsMemberTask umsMemberTask, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsMemberTask> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsMemberTask> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsMemberTask getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsMemberTask umsMemberTask) {
        return baseMapper.insert(umsMemberTask);
    }

    @Override
    public int edit(UmsMemberTask umsMemberTask) {
        return baseMapper.updateById(umsMemberTask);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

