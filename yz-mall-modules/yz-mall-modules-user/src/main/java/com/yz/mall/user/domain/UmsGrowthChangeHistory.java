package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 成长值变化历史记录表(UmsGrowthChangeHistory)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_growth_change_history")
public class UmsGrowthChangeHistory extends BaseEntity {

    @TableId
    private Long id;

    private Long memberId;

    private Date createTime;
    /**
     * 改变类型：0->增加；1->减少
     */
    private Integer changeType;
    /**
     * 积分改变数量
     */
    private Integer changeCount;
    /**
     * 操作人员
     */
    private String operateMan;
    /**
     * 操作备注
     */
    private String operateNote;
    /**
     * 积分来源：0->购物；1->管理员修改
     */
    private Integer sourceType;

}

