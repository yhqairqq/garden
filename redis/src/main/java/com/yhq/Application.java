package com.yhq;

import com.yhq.redis.entity.User;
import com.yhq.redis.service.UserService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yhqairqq@163.com on 21/02/2017.
 */
public class Application {

    static ApplicationContext applicationContext;

    @BeforeClass
    public static void initSpring() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/garden-redis-config.xml");
    }

    @Test
    public void consumer() throws InterruptedException {
        UserService userService = applicationContext.getBean(UserService.class);
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setUserId("192554785@163.com");
        System.out.println("=======addUser===================");
        userService.addUser(user);
    }

    @AfterClass
    public static void destroySpring() {
        ((AbstractApplicationContext) applicationContext).destroy();
    }





    public static void main(String args[]){
        System.out.println(String.format("%s/img",System.getProperty("user.dir")));


        for (long i = 0; i < Long.MAX_VALUE; i++) {
            User user = new User();
            user.setUsername("zhangsan");
            user.setPassword("123456");
            user.setUserId("192554785@163.com");
            System.out.println(user);


        }
    }
}
