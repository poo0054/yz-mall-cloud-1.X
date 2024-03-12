package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_admin_role_relation")
public class UmsAdminRoleRelation extends BaseEntity {

    @TableId
    private Long id;

    private Long adminId;

    private Long roleId;

}

