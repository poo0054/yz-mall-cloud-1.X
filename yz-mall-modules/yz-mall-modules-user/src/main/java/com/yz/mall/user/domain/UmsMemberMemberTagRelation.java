package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户和标签关系表(UmsMemberMemberTagRelation)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_member_tag_relation")
public class UmsMemberMemberTagRelation extends BaseEntity {

    @TableId
    private Long id;

    private Long memberId;

    private Long tagId;

}

