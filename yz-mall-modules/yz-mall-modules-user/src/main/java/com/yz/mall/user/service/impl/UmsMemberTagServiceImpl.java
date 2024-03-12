package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMemberTag;
import com.yz.mall.user.mapper.UmsMemberTagMapper;
import com.yz.mall.user.service.UmsMemberTagService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 用户标签表(UmsMemberTag)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:58
 */
@RequiredArgsConstructor
@Service("umsMemberTagService")
public class UmsMemberTagServiceImpl implements UmsMemberTagService {

    private final UmsMemberTagMapper baseMapper;


    @Override
    public TableDataInfo<UmsMemberTag> listPage(UmsMemberTag umsMemberTag, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsMemberTag> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsMemberTag> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsMemberTag getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsMemberTag umsMemberTag) {
        return baseMapper.insert(umsMemberTag);
    }

    @Override
    public int edit(UmsMemberTag umsMemberTag) {
        return baseMapper.updateById(umsMemberTag);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

