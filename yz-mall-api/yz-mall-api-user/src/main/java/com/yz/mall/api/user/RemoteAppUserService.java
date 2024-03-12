package com.yz.mall.api.user;

import com.yz.mall.common.core.constant.ServiceNameConstants;
import com.yz.mall.common.core.domain.UserDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author wx
 * @version 1.0
 * @date 2023/7/9 10:31
 **/
@FeignClient(contextId = "remoteAppUserService", value = ServiceNameConstants.USER_SERVICE)
public interface RemoteAppUserService {

    @GetMapping("/sso/loadByUsername")
    UserDto loadUserByUsername(@RequestParam("username") String username);

}
