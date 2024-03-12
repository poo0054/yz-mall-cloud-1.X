package com.yz.mall.user.service;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.user.domain.UmsIntegrationChangeHistory;

import java.io.Serializable;
import java.util.List;


/**
 * 积分变化历史记录表(UmsIntegrationChangeHistory)表服务接口
 *
 * @author wx
 * @since 2023-07-08 15:20:45
 */
public interface UmsIntegrationChangeHistoryService {

    /**
     * 分页查询所有数据
     *
     * @param pageQuery                   分页对象
     * @param umsIntegrationChangeHistory 查询实体
     * @return 所有数据
     */
    TableDataInfo<UmsIntegrationChangeHistory> listPage(UmsIntegrationChangeHistory umsIntegrationChangeHistory, PageQuery pageQuery);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    UmsIntegrationChangeHistory getInfo(Serializable id);

    /**
     * 新增数据
     *
     * @param umsIntegrationChangeHistory 实体对象
     * @return 新增结果
     */
    int add(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 修改数据
     *
     * @param umsIntegrationChangeHistory 实体对象
     * @return 修改结果
     */
    int edit(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    int remove(List<Long> idList);
}

