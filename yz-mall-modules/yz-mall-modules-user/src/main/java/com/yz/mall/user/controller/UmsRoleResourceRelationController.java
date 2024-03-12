package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsRoleResourceRelation;
import com.yz.mall.user.service.UmsRoleResourceRelationService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:21:08
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsRoleResourceRelation")
public class UmsRoleResourceRelationController extends BaseController {

    private final UmsRoleResourceRelationService umsRoleResourceRelationService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery               分页对象
     * @param umsRoleResourceRelation 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsRoleResourceRelation> listPage(UmsRoleResourceRelation umsRoleResourceRelation, PageQuery pageQuery) {
        return umsRoleResourceRelationService.listPage(umsRoleResourceRelation, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsRoleResourceRelation> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsRoleResourceRelationService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsRoleResourceRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsRoleResourceRelation umsRoleResourceRelation) {
        int row = umsRoleResourceRelationService.add(umsRoleResourceRelation);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsRoleResourceRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsRoleResourceRelation umsRoleResourceRelation) {
        int row = umsRoleResourceRelationService.edit(umsRoleResourceRelation);
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
        int row = umsRoleResourceRelationService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

