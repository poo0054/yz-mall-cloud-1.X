package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 会员统计信息(UmsMemberStatisticsInfo)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_statistics_info")
public class UmsMemberStatisticsInfo extends BaseEntity {

    @TableId
    private Long id;

    private Long memberId;
    /**
     * 累计消费金额
     */
    private Double consumeAmount;
    /**
     * 订单数量
     */
    private Integer orderCount;
    /**
     * 优惠券数量
     */
    private Integer couponCount;
    /**
     * 评价数
     */
    private Integer commentCount;
    /**
     * 退货数量
     */
    private Integer returnOrderCount;
    /**
     * 登录次数
     */
    private Integer loginCount;
    /**
     * 关注数量
     */
    private Integer attendCount;
    /**
     * 粉丝数量
     */
    private Integer fansCount;

    private Integer collectProductCount;

    private Integer collectSubjectCount;

    private Integer collectTopicCount;

    private Integer collectCommentCount;

    private Integer inviteFriendCount;
    /**
     * 最后一次下订单时间
     */
    private Date recentOrderTime;

}

