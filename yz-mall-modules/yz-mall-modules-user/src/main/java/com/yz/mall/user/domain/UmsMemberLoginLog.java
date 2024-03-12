package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 会员登录记录(UmsMemberLoginLog)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_login_log")
public class UmsMemberLoginLog extends BaseEntity {

    @TableId
    private Long id;

    private Long memberId;

    private Date createTime;

    private String ip;

    private String city;
    /**
     * 登录类型：0->PC；1->android;2->ios;3->小程序
     */
    private Integer loginType;

    private String province;

}

