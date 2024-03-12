package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsMemberStatisticsInfo;
import com.yz.mall.user.service.UmsMemberStatisticsInfoService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员统计信息(UmsMemberStatisticsInfo)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:56
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsMemberStatisticsInfo")
public class UmsMemberStatisticsInfoController extends BaseController {

    private final UmsMemberStatisticsInfoService umsMemberStatisticsInfoService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery               分页对象
     * @param umsMemberStatisticsInfo 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsMemberStatisticsInfo> listPage(UmsMemberStatisticsInfo umsMemberStatisticsInfo, PageQuery pageQuery) {
        return umsMemberStatisticsInfoService.listPage(umsMemberStatisticsInfo, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsMemberStatisticsInfo> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsMemberStatisticsInfoService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberStatisticsInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        int row = umsMemberStatisticsInfoService.add(umsMemberStatisticsInfo);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsMemberStatisticsInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        int row = umsMemberStatisticsInfoService.edit(umsMemberStatisticsInfo);
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
        int row = umsMemberStatisticsInfoService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

