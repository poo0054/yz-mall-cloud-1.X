package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户标签表(UmsMemberTag)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_tag")
public class UmsMemberTag extends BaseEntity {

    @TableId
    private Long id;

    private String name;
    /**
     * 自动打标签完成订单数量
     */
    private Integer finishOrderCount;
    /**
     * 自动打标签完成订单金额
     */
    private Double finishOrderAmount;

}

