package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsMemberTag;
import com.yz.mall.user.service.UmsMemberTagService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 用户标签表(UmsMemberTag)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:57
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsMemberTag")
public class UmsMemberTagController extends BaseController {

    private final UmsMemberTagService umsMemberTagService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery    分页对象
     * @param umsMemberTag 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsMemberTag> listPage(UmsMemberTag umsMemberTag, PageQuery pageQuery) {
        return umsMemberTagService.listPage(umsMemberTag, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsMemberTag> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsMemberTagService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberTag 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsMemberTag umsMemberTag) {
        int row = umsMemberTagService.add(umsMemberTag);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsMemberTag 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsMemberTag umsMemberTag) {
        int row = umsMemberTagService.edit(umsMemberTag);
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
        int row = umsMemberTagService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

