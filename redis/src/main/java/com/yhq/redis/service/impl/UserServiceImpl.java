package com.yhq.redis.service.impl;

import com.yhq.common.annotation.UserSaveCache;
import com.yhq.redis.entity.User;
import com.yhq.redis.service.UserService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhqairqq@163.com on 21/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @UserSaveCache
    @Override
    public User addUser(User user) {
        System.out.println("addUser,@CachePut注解方法被调用啦。。。。。");
        return user;
    }

    @Cacheable(value = "user", key = "'id_'+#id") // ,key="'user_id_'+#id"
    @Override
    public User getUserByID(String id) {
        System.out.println("@Cacheable注解方法被调用啦。。。。。");
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setUserId("192554785@163.com");
        return user;
    }

    @CachePut(value = "user", key = "'users_'+#user.getId()")
    @Override
    public List<User> getUsers(User user) {
        System.out.println("@CachePut注解方法被调用啦。。。。。");
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User temp = new User();
            temp.setUsername("username" + i);
            users.add(temp);
        }
        return users;
    }
}
