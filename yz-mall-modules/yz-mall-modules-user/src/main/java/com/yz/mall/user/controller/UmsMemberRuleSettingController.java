package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsMemberRuleSetting;
import com.yz.mall.user.service.UmsMemberRuleSettingService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 会员积分成长规则表(UmsMemberRuleSetting)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:55
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsMemberRuleSetting")
public class UmsMemberRuleSettingController extends BaseController {

    private final UmsMemberRuleSettingService umsMemberRuleSettingService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery            分页对象
     * @param umsMemberRuleSetting 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsMemberRuleSetting> listPage(UmsMemberRuleSetting umsMemberRuleSetting, PageQuery pageQuery) {
        return umsMemberRuleSettingService.listPage(umsMemberRuleSetting, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsMemberRuleSetting> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsMemberRuleSettingService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberRuleSetting 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsMemberRuleSetting umsMemberRuleSetting) {
        int row = umsMemberRuleSettingService.add(umsMemberRuleSetting);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsMemberRuleSetting 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsMemberRuleSetting umsMemberRuleSetting) {
        int row = umsMemberRuleSettingService.edit(umsMemberRuleSetting);
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
        int row = umsMemberRuleSettingService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

