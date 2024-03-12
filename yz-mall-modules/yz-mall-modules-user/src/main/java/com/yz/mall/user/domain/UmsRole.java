package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台用户角色表(UmsRole)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:21:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_role")
public class UmsRole extends BaseEntity {

    @TableId
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 后台用户数量
     */
    private Integer adminCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;

    private Integer sort;

}

