package com.yhq.redis.service;

import com.yhq.redis.entity.User;
import com.yhq.redis.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by yhqairqq@163.com on 21/02/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/garden-redis-config.xml" })
public class UserServiceImplTest {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Autowired
    private RedisCacheManager redisCacheManager;


//    @Autowired
//    private UserService userService;

    @Test
    public void redisTest() throws InterruptedException {




        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte [] key = "tempkey1".getBytes();
                byte[] value = "tempvalue1".getBytes();
                redisConnection.set(key, value);
                return true;
            }
        });


       String ping =  redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {


                return redisConnection.ping();
            }
        });

        System.out.println(ping);

        String result =  redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {


                return new String(redisConnection.get("tempkey".getBytes()));
            }
        });

        System.out.println(result);


        List<String> patterns = redisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                Iterator<byte[]> iter= redisConnection.keys("temp*".getBytes()).iterator();

                List<String> s = new ArrayList<String>();
                while(iter.hasNext()){
                    byte[] result = iter.next();
                    s.add(new String(result));

                }
                return s;
            }
        });


        for (String pattern : patterns) {
            System.out.println(pattern);
        }

//        patterns
//                .stream()
////                .filter((s) -> s.startsWith("a"))
//                .forEach(System.out::println);




//       /连接本地的 Redis 服务
//        Jedis jedis = new Jedis("120.132.3.92",6379);
//        jedis.auth("123456");
//        String keys = "name";
//        jedis.del(keys);
//        jedis.set(keys, "aaaaa");
//        String value = jedis.get(keys);
//        System.out.println(value);


    }



}
