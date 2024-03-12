package com.yz.mall.user.service;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.user.domain.UmsResource;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 后台资源表(UmsResource)表服务接口
 *
 * @author wx
 * @since 2023-07-08 15:21:03
 */
public interface UmsResourceService {

    /**
     * 分页查询所有数据
     *
     * @param pageQuery   分页对象
     * @param umsResource 查询实体
     * @return 所有数据
     */
    TableDataInfo<UmsResource> listPage(UmsResource umsResource, PageQuery pageQuery);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    UmsResource getInfo(Serializable id);

    /**
     * 新增数据
     *
     * @param umsResource 实体对象
     * @return 新增结果
     */
    int add(UmsResource umsResource);

    /**
     * 修改数据
     *
     * @param umsResource 实体对象
     * @return 修改结果
     */
    int edit(UmsResource umsResource);

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    int remove(List<Long> idList);

    /**
     * 初始化资源到缓存
     *
     * @return
     */
    Map<String, List<String>> initResourceRolesMap();
}

