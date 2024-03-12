package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 积分消费设置(UmsIntegrationConsumeSetting)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_integration_consume_setting")
public class UmsIntegrationConsumeSetting extends BaseEntity {

    @TableId
    private Long id;
    /**
     * 每一元需要抵扣的积分数量
     */
    private Integer deductionPerAmount;
    /**
     * 每笔订单最高抵用百分比
     */
    private Integer maxPercentPerOrder;
    /**
     * 每次使用积分最小单位100
     */
    private Integer useUnit;
    /**
     * 是否可以和优惠券同用；0->不可以；1->可以
     */
    private Integer couponStatus;

}

