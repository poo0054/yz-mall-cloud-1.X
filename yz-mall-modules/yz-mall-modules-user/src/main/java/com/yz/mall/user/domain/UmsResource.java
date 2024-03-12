package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台资源表(UmsResource)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:21:02
 */
@Data
@NoArgsConstructor
@TableName("ums_resource")
public class UmsResource {

    @TableId
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源URL
     */
    private String url;
    /**
     * 描述
     */
    private String description;
    /**
     * 资源分类ID
     */
    private Long categoryId;

}

