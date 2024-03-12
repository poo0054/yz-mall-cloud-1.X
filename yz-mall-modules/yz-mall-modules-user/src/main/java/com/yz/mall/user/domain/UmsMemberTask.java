package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 会员任务表(UmsMemberTask)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_task")
public class UmsMemberTask extends BaseEntity {

    @TableId
    private Long id;

    private String name;
    /**
     * 赠送成长值
     */
    private Integer growth;
    /**
     * 赠送积分
     */
    private Integer intergration;
    /**
     * 任务类型：0->新手任务；1->日常任务
     */
    private Integer type;

}

