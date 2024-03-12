package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsRolePermissionRelation;
import com.yz.mall.user.service.UmsRolePermissionRelationService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台用户角色和权限关系表(UmsRolePermissionRelation)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:21:07
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsRolePermissionRelation")
public class UmsRolePermissionRelationController extends BaseController {

    private final UmsRolePermissionRelationService umsRolePermissionRelationService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery                 分页对象
     * @param umsRolePermissionRelation 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsRolePermissionRelation> listPage(UmsRolePermissionRelation umsRolePermissionRelation, PageQuery pageQuery) {
        return umsRolePermissionRelationService.listPage(umsRolePermissionRelation, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsRolePermissionRelation> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsRolePermissionRelationService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsRolePermissionRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsRolePermissionRelation umsRolePermissionRelation) {
        int row = umsRolePermissionRelationService.add(umsRolePermissionRelation);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsRolePermissionRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsRolePermissionRelation umsRolePermissionRelation) {
        int row = umsRolePermissionRelationService.edit(umsRolePermissionRelation);
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
        int row = umsRolePermissionRelationService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

