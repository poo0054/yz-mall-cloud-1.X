package com.yz.mall.user.service;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.user.domain.UmsAdminPermissionRelation;

import java.io.Serializable;
import java.util.List;


/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表服务接口
 *
 * @author wx
 * @since 2023-07-08 15:20:41
 */
public interface UmsAdminPermissionRelationService {

    /**
     * 分页查询所有数据
     *
     * @param pageQuery                  分页对象
     * @param umsAdminPermissionRelation 查询实体
     * @return 所有数据
     */
    TableDataInfo<UmsAdminPermissionRelation> listPage(UmsAdminPermissionRelation umsAdminPermissionRelation, PageQuery pageQuery);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    UmsAdminPermissionRelation getInfo(Serializable id);

    /**
     * 新增数据
     *
     * @param umsAdminPermissionRelation 实体对象
     * @return 新增结果
     */
    int add(UmsAdminPermissionRelation umsAdminPermissionRelation);

    /**
     * 修改数据
     *
     * @param umsAdminPermissionRelation 实体对象
     * @return 修改结果
     */
    int edit(UmsAdminPermissionRelation umsAdminPermissionRelation);

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    int remove(List<Long> idList);
}

