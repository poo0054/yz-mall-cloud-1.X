package com.yz.mall.user.service;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.user.domain.UmsMenu;
import com.yz.mall.user.domain.UmsRole;

import java.io.Serializable;
import java.util.List;


/**
 * 后台用户角色表(UmsRole)表服务接口
 *
 * @author wx
 * @since 2023-07-08 15:21:05
 */
public interface UmsRoleService {

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param umsRole   查询实体
     * @return 所有数据
     */
    TableDataInfo<UmsRole> listPage(UmsRole umsRole, PageQuery pageQuery);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    UmsRole getInfo(Serializable id);

    /**
     * 新增数据
     *
     * @param umsRole 实体对象
     * @return 新增结果
     */
    int add(UmsRole umsRole);

    /**
     * 修改数据
     *
     * @param umsRole 实体对象
     * @return 修改结果
     */
    int edit(UmsRole umsRole);

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    int remove(List<Long> idList);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);
}

