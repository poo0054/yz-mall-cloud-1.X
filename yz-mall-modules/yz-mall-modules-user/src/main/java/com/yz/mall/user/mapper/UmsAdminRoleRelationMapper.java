package com.yz.mall.user.mapper;


import com.yz.mall.common.mybatis.mapper.BaseMapperPlus;
import com.yz.mall.user.domain.UmsAdminRoleRelation;
import com.yz.mall.user.domain.UmsRole;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表数据库访问层
 *
 * @author wx
 * @since 2023-07-08 15:20:42
 */
public interface UmsAdminRoleRelationMapper extends BaseMapperPlus<UmsAdminRoleRelationMapper, UmsAdminRoleRelation, UmsAdminRoleRelation> {


    /**
     * 获取用于所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);
}

