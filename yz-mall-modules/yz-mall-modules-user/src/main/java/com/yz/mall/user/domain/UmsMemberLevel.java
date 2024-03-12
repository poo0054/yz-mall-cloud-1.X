package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 会员等级表(UmsMemberLevel)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:49
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_level")
public class UmsMemberLevel extends BaseEntity {

    @TableId
    private Long id;

    private String name;

    private Integer growthPoint;
    /**
     * 是否为默认等级：0->不是；1->是
     */
    private Integer defaultStatus;
    /**
     * 免运费标准
     */
    private Double freeFreightPoint;
    /**
     * 每次评价获取的成长值
     */
    private Integer commentGrowthPoint;
    /**
     * 是否有免邮特权
     */
    private Integer priviledgeFreeFreight;
    /**
     * 是否有签到特权
     */
    private Integer priviledgeSignIn;
    /**
     * 是否有评论获奖励特权
     */
    private Integer priviledgeComment;
    /**
     * 是否有专享活动特权
     */
    private Integer priviledgePromotion;
    /**
     * 是否有会员价格特权
     */
    private Integer priviledgeMemberPrice;
    /**
     * 是否有生日特权
     */
    private Integer priviledgeBirthday;

    private String note;

}

