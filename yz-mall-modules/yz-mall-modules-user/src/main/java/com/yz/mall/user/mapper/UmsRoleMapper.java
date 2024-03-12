package com.yz.mall.user.mapper;


import com.yz.mall.common.mybatis.mapper.BaseMapperPlus;
import com.yz.mall.user.domain.UmsMenu;
import com.yz.mall.user.domain.UmsRole;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户角色表(UmsRole)表数据库访问层
 *
 * @author wx
 * @since 2023-07-08 15:21:05
 */
public interface UmsRoleMapper extends BaseMapperPlus<UmsRoleMapper, UmsRole, UmsRole> {


    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
}

