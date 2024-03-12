package com.yz.mall.common.core.web.controller;


import com.yz.mall.common.core.web.api.CommonResult;

import lombok.extern.slf4j.Slf4j;

/**
 * web层通用数据处理
 *
 */
@Slf4j
public class BaseController {

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected CommonResult<Void> toAjax(int rows) {
        return rows > 0 ? CommonResult.success() : CommonResult.failed();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected CommonResult<Void> toAjax(boolean result) {
        return result ? CommonResult.success() : CommonResult.failed();
    }

}
