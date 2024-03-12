package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMemberLoginLog;
import com.yz.mall.user.mapper.UmsMemberLoginLogMapper;
import com.yz.mall.user.service.UmsMemberLoginLogService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员登录记录(UmsMemberLoginLog)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:51
 */
@RequiredArgsConstructor
@Service("umsMemberLoginLogService")
public class UmsMemberLoginLogServiceImpl implements UmsMemberLoginLogService {

    private final UmsMemberLoginLogMapper baseMapper;


    @Override
    public TableDataInfo<UmsMemberLoginLog> listPage(UmsMemberLoginLog umsMemberLoginLog, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsMemberLoginLog> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsMemberLoginLog> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsMemberLoginLog getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsMemberLoginLog umsMemberLoginLog) {
        return baseMapper.insert(umsMemberLoginLog);
    }

    @Override
    public int edit(UmsMemberLoginLog umsMemberLoginLog) {
        return baseMapper.updateById(umsMemberLoginLog);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

