package com.yz.mall.user.controller;


import com.yz.mall.api.auth.domain.Oauth2TokenDto;
import com.yz.mall.common.core.domain.UserDto;
import com.yz.mall.common.core.web.api.CommonPage;
import com.yz.mall.common.mybatis.page.PageQuery;
import com.yz.mall.common.mybatis.page.TableDataInfo;
import com.yz.mall.common.core.web.api.CommonResult;
import com.yz.mall.common.core.web.controller.BaseController;
import com.yz.mall.user.domain.UmsAdmin;
import com.yz.mall.user.domain.UmsRole;
import com.yz.mall.user.domain.query.UmsAdminLoginQuery;
import com.yz.mall.user.domain.query.UmsAdminQuery;
import com.yz.mall.user.service.UmsAdminService;
import com.yz.mall.user.service.UmsRoleService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * 后台用户表(UmsAdmin)表控制层
 *
 * @author wx
 * @since 2023-07-08 15:20:38
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class UmsAdminController extends BaseController {

    private final UmsAdminService umsAdminService;

    private final UmsRoleService roleService;

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param umsAdmin  查询实体
     * @return 所有数据
     */
    @GetMapping("/listPage")
    public TableDataInfo<UmsAdmin> listPage(UmsAdmin umsAdmin, PageQuery pageQuery) {
        return umsAdminService.listPage(umsAdmin, pageQuery);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult<UmsAdmin> getInfo(@PathVariable Serializable id) {
        return CommonResult.success(umsAdminService.getInfo(id));
    }

    /**
     * 新增数据
     *
     * @param umsAdmin 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult<Void> add(@Validated @RequestBody UmsAdmin umsAdmin) {
        int row = umsAdminService.add(umsAdmin);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    /**
     * 修改数据
     *
     * @param umsAdmin 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult<Void> edit(@RequestBody UmsAdmin umsAdmin) {
        int row = umsAdminService.edit(umsAdmin);
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
        int row = umsAdminService.remove(idList);
        if (row > 0) {
            return CommonResult.success();
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public CommonResult<UmsAdmin> register(@Validated @RequestBody UmsAdminQuery umsAdminQuery) {
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminQuery);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登出功能")
    @PostMapping(value = "/logout")
    public CommonResult<Void> logout() {
        return CommonResult.success(null);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public CommonResult<Oauth2TokenDto> login(@Validated @RequestBody UmsAdminLoginQuery loginQuery) {
        return umsAdminService.login(loginQuery.getUsername(), loginQuery.getPassword());
    }

    @ApiOperation(value = "根据用户名获取通用用户信息")
    @GetMapping(value = "/loadByUsername")
    public UserDto loadUserByUsername(@RequestParam("username") String username) {
        UserDto userDTO = umsAdminService.loadUserByUsername(username);
        return userDTO;
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public CommonResult<Map<String, Object>> getAdminInfo() {
        UmsAdmin umsAdmin = umsAdminService.getCurrentAdmin();
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = umsAdminService.getRoleList(umsAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return CommonResult.success(data);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<UmsAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsAdmin> adminList = adminService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(adminList));
    }
}

