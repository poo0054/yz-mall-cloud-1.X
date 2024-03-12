package com.yz.mall.user.service.impl;


import com.yz.mall.common.redis.utils.RedisUtils;
import com.yz.mall.user.domain.UmsAdmin;
import com.yz.mall.user.service.UmsAdminCacheService;
import com.yz.mall.user.service.UmsAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

import lombok.RequiredArgsConstructor;

/**
 * UmsAdminCacheService实现类
 *
 * @author wx
 * @date 2023/7/9 14:46
 */
@RequiredArgsConstructor
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {


    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Override
    public void delAdmin(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
        RedisUtils.deleteObject(key);
    }

    @Override
    public UmsAdmin getAdmin(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
        return RedisUtils.getCacheObject(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getId();
        RedisUtils.setCacheObject(key, admin, Duration.ofSeconds(REDIS_EXPIRE));
    }
}
