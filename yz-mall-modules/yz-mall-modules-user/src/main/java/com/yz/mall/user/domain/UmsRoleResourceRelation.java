package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:21:08
 */
@Data
@NoArgsConstructor
@TableName("ums_role_resource_relation")
public class UmsRoleResourceRelation {

    @TableId
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 资源ID
     */
    private Long resourceId;

}

