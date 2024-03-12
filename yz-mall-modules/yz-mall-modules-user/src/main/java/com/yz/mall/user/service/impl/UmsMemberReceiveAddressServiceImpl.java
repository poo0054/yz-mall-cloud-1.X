package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMemberReceiveAddress;
import com.yz.mall.user.mapper.UmsMemberReceiveAddressMapper;
import com.yz.mall.user.service.UmsMemberReceiveAddressService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员收货地址表(UmsMemberReceiveAddress)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:20:55
 */
@RequiredArgsConstructor
@Service("umsMemberReceiveAddressService")
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

    private final UmsMemberReceiveAddressMapper baseMapper;


    @Override
    public TableDataInfo<UmsMemberReceiveAddress> listPage(UmsMemberReceiveAddress umsMemberReceiveAddress, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsMemberReceiveAddress> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsMemberReceiveAddress> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsMemberReceiveAddress getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        return baseMapper.insert(umsMemberReceiveAddress);
    }

    @Override
    public int edit(UmsMemberReceiveAddress umsMemberReceiveAddress) {
        return baseMapper.updateById(umsMemberReceiveAddress);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

