package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsMemberLoginLog;
import com.yz.mall.user.service.UmsMemberLoginLogService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员登录记录(UmsMemberLoginLog)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:50
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsMemberLoginLog")
public class UmsMemberLoginLogController extends BaseController {

    private final UmsMemberLoginLogService umsMemberLoginLogService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery         分页对象
     * @param umsMemberLoginLog 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsMemberLoginLog> listPage(UmsMemberLoginLog umsMemberLoginLog, PageQuery pageQuery) {
        return umsMemberLoginLogService.listPage(umsMemberLoginLog, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsMemberLoginLog> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsMemberLoginLogService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberLoginLog 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsMemberLoginLog umsMemberLoginLog) {
        int row = umsMemberLoginLogService.add(umsMemberLoginLog);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsMemberLoginLog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsMemberLoginLog umsMemberLoginLog) {
        int row = umsMemberLoginLogService.edit(umsMemberLoginLog);
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
        int row = umsMemberLoginLogService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

