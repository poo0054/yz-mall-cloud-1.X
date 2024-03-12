package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 会员积分成长规则表(UmsMemberRuleSetting)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:55
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_rule_setting")
public class UmsMemberRuleSetting extends BaseEntity {

    @TableId
    private Long id;
    /**
     * 连续签到天数
     */
    private Integer continueSignDay;
    /**
     * 连续签到赠送数量
     */
    private Integer continueSignPoint;
    /**
     * 每消费多少元获取1个点
     */
    private Double consumePerPoint;
    /**
     * 最低获取点数的订单金额
     */
    private Double lowOrderAmount;
    /**
     * 每笔订单最高获取点数
     */
    private Integer maxPointPerOrder;
    /**
     * 类型：0->积分规则；1->成长值规则
     */
    private Integer type;

}

