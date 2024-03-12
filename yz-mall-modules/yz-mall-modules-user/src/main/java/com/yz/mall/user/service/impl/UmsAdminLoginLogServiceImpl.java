package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsAdminLoginLog;
import com.yz.mall.user.mapper.UmsAdminLoginLogMapper;
import com.yz.mall.user.service.UmsAdminLoginLogService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台用户登录日志表(UmsAdminLoginLog)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:40
 */
@RequiredArgsConstructor
@Service("umsAdminLoginLogService")
public class UmsAdminLoginLogServiceImpl implements UmsAdminLoginLogService {

    private final UmsAdminLoginLogMapper baseMapper;


    @Override
    public TableDataInfo<UmsAdminLoginLog> listPage(UmsAdminLoginLog umsAdminLoginLog, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsAdminLoginLog> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsAdminLoginLog> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsAdminLoginLog getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsAdminLoginLog umsAdminLoginLog) {
        return baseMapper.insert(umsAdminLoginLog);
    }

    @Override
    public int edit(UmsAdminLoginLog umsAdminLoginLog) {
        return baseMapper.updateById(umsAdminLoginLog);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

