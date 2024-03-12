package com.yz.mall.user.service;


import com.yz.mall.api.auth.domain.Oauth2TokenDto;
import com.yz.mall.common.core.domain.UserDto;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.user.domain.UmsAdmin;
import com.yz.mall.user.domain.UmsRole;
import com.yz.mall.user.domain.query.UmsAdminQuery;

import java.io.Serializable;
import java.util.List;


/**
 * 后台用户表(UmsAdmin)表服务接口
 *
 * @author wx
 * @since 2023-07-08 15:20:39
 */
public interface UmsAdminService {

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param umsAdmin  查询实体
     * @return 所有数据
     */
    TableDataInfo<UmsAdmin> listPage(UmsAdmin umsAdmin, PageQuery pageQuery);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    UmsAdmin getInfo(Serializable id);

    /**
     * 新增数据
     *
     * @param umsAdmin 实体对象
     * @return 新增结果
     */
    int add(UmsAdmin umsAdmin);

    /**
     * 修改数据
     *
     * @param umsAdmin 实体对象
     * @return 修改结果
     */
    int edit(UmsAdmin umsAdmin);

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    int remove(List<Long> idList);

    /**
     * 认证返回token
     *
     * @param username
     * @param password
     * @return
     */
    CommonResult<Oauth2TokenDto> login(String username, String password);


    /**
     * 根据用户名获取
     *
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户
     *
     * @param username
     * @return
     */
    UserDto loadUserByUsername(String username);

    /**
     * 获取当前登录后台用户
     */
    UmsAdmin getCurrentAdmin();


    /**
     * 获取用户缓存
     *
     * @return
     */
    UmsAdminCacheService getCacheService();

    /**
     * 获取角色
     *
     * @param id
     * @return
     */
    List<UmsRole> getRoleList(Long id);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminQuery umsAdminParam);
}

