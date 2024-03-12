package com.yz.mall.user.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yz.mall.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 会员与产品分类关系表（用户喜欢的分类）(UmsMemberProductCategoryRelation)表实体类
 *
 * @author wx
 * @since 2023-07-08 15:20:53
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("ums_member_product_category_relation")
public class UmsMemberProductCategoryRelation extends BaseEntity {

    @TableId
    private Long id;

    private Long memberId;

    private Long productCategoryId;

}

