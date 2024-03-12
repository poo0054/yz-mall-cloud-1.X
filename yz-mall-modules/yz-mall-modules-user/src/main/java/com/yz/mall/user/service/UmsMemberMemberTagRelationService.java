package com.yz.mall.user.service;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.user.domain.UmsMemberMemberTagRelation;

import java.io.Serializable;
import java.util.List;


/**
 * 用户和标签关系表(UmsMemberMemberTagRelation)表服务接口
 *
 * @author wx
 * @since 2023-07-08 15:20:52
 */
public interface UmsMemberMemberTagRelationService {

    /**
     * 分页查询所有数据
     *
     * @param pageQuery                  分页对象
     * @param umsMemberMemberTagRelation 查询实体
     * @return 所有数据
     */
    TableDataInfo<UmsMemberMemberTagRelation> listPage(UmsMemberMemberTagRelation umsMemberMemberTagRelation, PageQuery pageQuery);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    UmsMemberMemberTagRelation getInfo(Serializable id);

    /**
     * 新增数据
     *
     * @param umsMemberMemberTagRelation 实体对象
     * @return 新增结果
     */
    int add(UmsMemberMemberTagRelation umsMemberMemberTagRelation);

    /**
     * 修改数据
     *
     * @param umsMemberMemberTagRelation 实体对象
     * @return 修改结果
     */
    int edit(UmsMemberMemberTagRelation umsMemberMemberTagRelation);

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    int remove(List<Long> idList);
}

