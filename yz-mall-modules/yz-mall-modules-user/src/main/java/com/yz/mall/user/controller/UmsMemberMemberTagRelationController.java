package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsMemberMemberTagRelation;
import com.yz.mall.user.service.UmsMemberMemberTagRelationService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 用户和标签关系表(UmsMemberMemberTagRelation)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:51
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsMemberMemberTagRelation")
public class UmsMemberMemberTagRelationController extends BaseController {

    private final UmsMemberMemberTagRelationService umsMemberMemberTagRelationService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery                  分页对象
     * @param umsMemberMemberTagRelation 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsMemberMemberTagRelation> listPage(UmsMemberMemberTagRelation umsMemberMemberTagRelation, PageQuery pageQuery) {
        return umsMemberMemberTagRelationService.listPage(umsMemberMemberTagRelation, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsMemberMemberTagRelation> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsMemberMemberTagRelationService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberMemberTagRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsMemberMemberTagRelation umsMemberMemberTagRelation) {
        int row = umsMemberMemberTagRelationService.add(umsMemberMemberTagRelation);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsMemberMemberTagRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsMemberMemberTagRelation umsMemberMemberTagRelation) {
        int row = umsMemberMemberTagRelationService.edit(umsMemberMemberTagRelation);
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
        int row = umsMemberMemberTagRelationService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

