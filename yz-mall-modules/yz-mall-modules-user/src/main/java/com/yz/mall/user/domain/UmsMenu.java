package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台菜单表(UmsMenu)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:21:00
 */
@Data
@NoArgsConstructor
@TableName("ums_menu")
public class UmsMenu {

    @TableId
    private Long id;
    /**
     * 父级ID
     */
    private Long parentId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 菜单级数
     */
    private Integer level;
    /**
     * 菜单排序
     */
    private Integer sort;
    /**
     * 前端名称
     */
    private String name;
    /**
     * 前端图标
     */
    private String icon;
    /**
     * 前端隐藏
     */
    private Integer hidden;

}

