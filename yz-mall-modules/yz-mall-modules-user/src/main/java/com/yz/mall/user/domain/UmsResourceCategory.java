package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 资源分类表(UmsResourceCategory)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:21:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_resource_category")
public class UmsResourceCategory extends BaseEntity {

    @TableId
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;

}

