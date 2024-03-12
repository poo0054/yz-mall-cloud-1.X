package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_admin_permission_relation")
public class UmsAdminPermissionRelation extends BaseEntity {

    @TableId
    private Long id;

    private Long adminId;

    private Long permissionId;

    private Integer type;

}

