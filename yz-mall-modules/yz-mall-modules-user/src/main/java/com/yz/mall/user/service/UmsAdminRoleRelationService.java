package com.yz.mall.user.service;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.user.domain.UmsAdminRoleRelation;
import com.yz.mall.user.domain.UmsRole;

import java.io.Serializable;
import java.util.List;


/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表服务接口
 *
 * @author wx
 * @since 2023-07-08 15:20:43
 */
public interface UmsAdminRoleRelationService {

    /**
     * 分页查询所有数据
     *
     * @param pageQuery            分页对象
     * @param umsAdminRoleRelation 查询实体
     * @return 所有数据
     */
    TableDataInfo<UmsAdminRoleRelation> listPage(UmsAdminRoleRelation umsAdminRoleRelation, PageQuery pageQuery);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    UmsAdminRoleRelation getInfo(Serializable id);

    /**
     * 新增数据
     *
     * @param umsAdminRoleRelation 实体对象
     * @return 新增结果
     */
    int add(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 修改数据
     *
     * @param umsAdminRoleRelation 实体对象
     * @return 修改结果
     */
    int edit(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    int remove(List<Long> idList);

    public List<UmsRole> getRoleList(Long adminId);
}

