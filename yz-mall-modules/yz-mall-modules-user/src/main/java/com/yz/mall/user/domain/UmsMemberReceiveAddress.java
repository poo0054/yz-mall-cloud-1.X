package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 会员收货地址表(UmsMemberReceiveAddress)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:54
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_receive_address")
public class UmsMemberReceiveAddress extends BaseEntity {

    @TableId
    private Long id;

    private Long memberId;
    /**
     * 收货人名称
     */
    private String name;

    private String phoneNumber;
    /**
     * 是否为默认
     */
    private Integer defaultStatus;
    /**
     * 邮政编码
     */
    private String postCode;
    /**
     * 省份/直辖市
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区
     */
    private String region;
    /**
     * 详细地址(街道)
     */
    private String detailAddress;

}

