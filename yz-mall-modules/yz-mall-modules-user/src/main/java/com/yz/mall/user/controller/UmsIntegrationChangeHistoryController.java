package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsIntegrationChangeHistory;
import com.yz.mall.user.service.UmsIntegrationChangeHistoryService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 积分变化历史记录表(UmsIntegrationChangeHistory)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:45
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsIntegrationChangeHistory")
public class UmsIntegrationChangeHistoryController extends BaseController {

    private final UmsIntegrationChangeHistoryService umsIntegrationChangeHistoryService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery                   分页对象
     * @param umsIntegrationChangeHistory 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsIntegrationChangeHistory> listPage(UmsIntegrationChangeHistory umsIntegrationChangeHistory, PageQuery pageQuery) {
        return umsIntegrationChangeHistoryService.listPage(umsIntegrationChangeHistory, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsIntegrationChangeHistory> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsIntegrationChangeHistoryService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsIntegrationChangeHistory 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        int row = umsIntegrationChangeHistoryService.add(umsIntegrationChangeHistory);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsIntegrationChangeHistory 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        int row = umsIntegrationChangeHistoryService.edit(umsIntegrationChangeHistory);
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
        int row = umsIntegrationChangeHistoryService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

