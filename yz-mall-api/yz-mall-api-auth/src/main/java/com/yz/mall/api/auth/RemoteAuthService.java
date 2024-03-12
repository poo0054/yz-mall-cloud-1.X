package com.yz.mall.api.auth;


import com.yz.mall.api.auth.domain.Oauth2TokenDto;
import com.yz.mall.common.core.constant.ServiceNameConstants;
import com.yz.mall.common.core.web.api.CommonResult;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.ApiParam;

/**
 * 授权服务
 */
@FeignClient(contextId = "remoteAuthService", value = ServiceNameConstants.AUTH_SERVICE)
public interface RemoteAuthService {

    @PostMapping(value = "/oauth/token")
    CommonResult<Oauth2TokenDto> getAccessToken(@RequestParam Map<String, String> parameters);

}
