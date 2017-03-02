package com.yhq.common.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by yhqairqq@163.com on 21/02/2017.
 */
public class MethodCacheInterceptor {


    @Autowired
    private RedisTemplate redisTemplate;
}
