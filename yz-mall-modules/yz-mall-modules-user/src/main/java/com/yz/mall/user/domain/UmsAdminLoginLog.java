package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 后台用户登录日志表(UmsAdminLoginLog)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:39
 */
@Data
@NoArgsConstructor
@TableName("ums_admin_login_log")
public class UmsAdminLoginLog {

    @TableId
    private Long id;

    private Long adminId;

    private Date createTime;

    private String ip;

    private String address;
    /**
     * 浏览器登录类型
     */
    private String userAgent;

}

