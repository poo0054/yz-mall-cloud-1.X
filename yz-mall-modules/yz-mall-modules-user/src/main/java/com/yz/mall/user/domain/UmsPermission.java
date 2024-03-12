package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台用户权限表(UmsPermission)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:21:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_permission")
public class UmsPermission extends BaseEntity {

    @TableId
    private Long id;
    /**
     * 父级权限id
     */
    private Long pid;
    /**
     * 名称
     */
    private String name;
    /**
     * 权限值
     */
    private String value;
    /**
     * 图标
     */
    private String icon;
    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    private Integer type;
    /**
     * 前端资源路径
     */
    private String uri;
    /**
     * 启用状态；0->禁用；1->启用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 排序
     */
    private Integer sort;

}

