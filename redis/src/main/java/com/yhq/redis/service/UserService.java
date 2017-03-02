package com.yhq.redis.service;

import com.yhq.redis.entity.User;

import java.util.List;

/**
 * Created by yhqairqq@163.com on 21/02/2017.
 */
public interface UserService {


    User addUser(User user);

    User getUserByID(String id);

    List<User> getUsers(User user);
}
