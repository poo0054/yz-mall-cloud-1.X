package com.yz.mall.user.controller;


import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsAdminPermissionRelation;
import com.yz.mall.user.service.UmsAdminPermissionRelationService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)(UmsAdminPermissionRelation)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:41
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/umsAdminPermissionRelation")
public class UmsAdminPermissionRelationController extends BaseController {

    private final UmsAdminPermissionRelationService umsAdminPermissionRelationService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery                  分页对象
     * @param umsAdminPermissionRelation 查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsAdminPermissionRelation> listPage(UmsAdminPermissionRelation umsAdminPermissionRelation, PageQuery pageQuery) {
        return umsAdminPermissionRelationService.listPage(umsAdminPermissionRelation, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsAdminPermissionRelation> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsAdminPermissionRelationService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsAdminPermissionRelation 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsAdminPermissionRelation umsAdminPermissionRelation) {
        int row = umsAdminPermissionRelationService.add(umsAdminPermissionRelation);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsAdminPermissionRelation 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsAdminPermissionRelation umsAdminPermissionRelation) {
        int row = umsAdminPermissionRelationService.edit(umsAdminPermissionRelation);
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
        int row = umsAdminPermissionRelationService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

}

