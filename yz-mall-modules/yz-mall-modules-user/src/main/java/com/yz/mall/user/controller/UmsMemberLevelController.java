package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsMemberLevel;
import com.yz.mall.user.service.UmsMemberLevelService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员等级表(UmsMemberLevel)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:49
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsMemberLevel")
public class UmsMemberLevelController extends BaseController {

    private final UmsMemberLevelService umsMemberLevelService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery      分页对象
     * @param umsMemberLevel 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsMemberLevel> listPage(UmsMemberLevel umsMemberLevel, PageQuery pageQuery) {
        return umsMemberLevelService.listPage(umsMemberLevel, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsMemberLevel> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsMemberLevelService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberLevel 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsMemberLevel umsMemberLevel) {
        int row = umsMemberLevelService.add(umsMemberLevel);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsMemberLevel 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsMemberLevel umsMemberLevel) {
        int row = umsMemberLevelService.edit(umsMemberLevel);
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
        int row = umsMemberLevelService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

