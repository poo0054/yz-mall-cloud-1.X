package com.yz.mall.user.service;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.user.domain.UmsPermission;

import java.io.Serializable;
import java.util.List;


/**
 * 后台用户权限表(UmsPermission)表服务接口
 *
 * @author wx
 * @since 2023-07-08 15:21:02
 */
public interface UmsPermissionService {

    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param umsPermission 查询实体
     * @return 所有数据
     */
    TableDataInfo<UmsPermission> listPage(UmsPermission umsPermission, PageQuery pageQuery);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    UmsPermission getInfo(Serializable id);

    /**
     * 新增数据
     *
     * @param umsPermission 实体对象
     * @return 新增结果
     */
    int add(UmsPermission umsPermission);

    /**
     * 修改数据
     *
     * @param umsPermission 实体对象
     * @return 修改结果
     */
    int edit(UmsPermission umsPermission);

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    int remove(List<Long> idList);
}

