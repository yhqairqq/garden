package com.yhq.common.annotation;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

/**
 * Created by yhqairqq@163.com on 21/02/2017.
 */



@Caching(put = {
        @CachePut(value = "user", key = "'user_id_'+#user.id"),
        @CachePut(value = "user", key = "'user_username_'+#user.username"),
        @CachePut(value = "user", key = "'user_email_'+#user.email")
})
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UserSaveCache {
}
