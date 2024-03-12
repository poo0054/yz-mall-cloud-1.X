package com.yz.mall.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.util.StringUtils;
import com.yz.mall.user.domain.UmsMenu;
import com.yz.mall.user.mapper.UmsMenuMapper;
import com.yz.mall.user.service.UmsMenuService;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台菜单表(UmsMenu)表服务实现类
 *
 * @author wx
 * @since 2023-07-08 15:21:01
 */
@RequiredArgsConstructor
@Service("umsMenuService")
public class UmsMenuServiceImpl implements UmsMenuService {

    private final UmsMenuMapper baseMapper;


    @Override
    public TableDataInfo<UmsMenu> listPage(UmsMenu umsMenu, PageQuery pageQuery) {
        //Map<String, Object> params = umsAdmin.getParams();
        LambdaQueryWrapper<UmsMenu> lqw = new LambdaQueryWrapper<>();
//                .like(StringUtils.isNotBlank(logininfor.getIpaddr()), SysLogininfor::getIpaddr, logininfor.getIpaddr())
//                .eq(StringUtils.isNotBlank(logininfor.getStatus()), SysLogininfor::getStatus, logininfor.getStatus())
//                .like(StringUtils.isNotBlank(logininfor.getUserName()), SysLogininfor::getUserName, logininfor.getUserName())
//                .between(params.get("beginTime") != null && params.get("endTime") != null,
//                        SysLogininfor::getLoginTime, params.get("beginTime"), params.get("endTime"));
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<UmsMenu> page = baseMapper.selectPage(pageQuery.build(), lqw);
        return TableDataInfo.build(page);
    }

    @Override
    public UmsMenu getInfo(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int add(UmsMenu umsMenu) {
        return baseMapper.insert(umsMenu);
    }

    @Override
    public int edit(UmsMenu umsMenu) {
        return baseMapper.updateById(umsMenu);
    }

    @Override
    public int remove(List<Long> idList) {
        return baseMapper.deleteBatchIds(idList);
    }
}

