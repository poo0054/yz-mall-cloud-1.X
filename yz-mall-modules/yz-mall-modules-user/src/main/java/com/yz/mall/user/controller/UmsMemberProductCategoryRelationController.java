package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsMemberProductCategoryRelation;
import com.yz.mall.user.service.UmsMemberProductCategoryRelationService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员与产品分类关系表（用户喜欢的分类）(UmsMemberProductCategoryRelation)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:53
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsMemberProductCategoryRelation")
public class UmsMemberProductCategoryRelationController extends BaseController {

    private final UmsMemberProductCategoryRelationService umsMemberProductCategoryRelationService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery                        分页对象
     * @param umsMemberProductCategoryRelation 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsMemberProductCategoryRelation> listPage(UmsMemberProductCategoryRelation umsMemberProductCategoryRelation, PageQuery pageQuery) {
        return umsMemberProductCategoryRelationService.listPage(umsMemberProductCategoryRelation, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsMemberProductCategoryRelation> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsMemberProductCategoryRelationService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberProductCategoryRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsMemberProductCategoryRelation umsMemberProductCategoryRelation) {
        int row = umsMemberProductCategoryRelationService.add(umsMemberProductCategoryRelation);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsMemberProductCategoryRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsMemberProductCategoryRelation umsMemberProductCategoryRelation) {
        int row = umsMemberProductCategoryRelationService.edit(umsMemberProductCategoryRelation);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }


    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public CommonResult<Void> delete(@RequestParam("idList") List<Long> idList) {
        int row = umsMemberProductCategoryRelationService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

