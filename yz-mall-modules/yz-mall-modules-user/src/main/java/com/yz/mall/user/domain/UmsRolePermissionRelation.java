package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台用户角色和权限关系表(UmsRolePermissionRelation)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:21:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_role_permission_relation")
public class UmsRolePermissionRelation extends BaseEntity {

    @TableId
    private Long id;

    private Long roleId;

    private Long permissionId;

}

