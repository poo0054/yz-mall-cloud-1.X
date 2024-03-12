package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 会员表(UmsMember)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member")
public class UmsMember extends BaseEntity {

    @TableId
    private Long id;

    private Long memberLevelId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 帐号启用状态:0->禁用；1->启用
     */
    private Integer status;
    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 头像
     */
    private String icon;
    /**
     * 性别：0->未知；1->男；2->女
     */
    private Integer gender;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 所做城市
     */
    private String city;
    /**
     * 职业
     */
    private String job;
    /**
     * 个性签名
     */
    private String personalizedSignature;
    /**
     * 用户来源
     */
    private Integer sourceType;
    /**
     * 积分
     */
    private Integer integration;
    /**
     * 成长值
     */
    private Integer growth;
    /**
     * 剩余抽奖次数
     */
    private Integer luckeyCount;
    /**
     * 历史积分数量
     */
    private Integer historyIntegration;

}

