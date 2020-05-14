package com.example.demo;

import com.example.demo.entity.UserInfo;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 * Created by wangn on 2020/5/13.
 */
public class RedisTest {
    private static final String REDIS_KEY="user";

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        Gson gson=new Gson();
        UserInfo userInfo=new UserInfo("wangn",18);
        jedis.set(REDIS_KEY,gson.toJson(userInfo));
        UserInfo getUserInfoFromRedis=gson.fromJson(jedis.get(REDIS_KEY),UserInfo.class);
        System.out.println("get:"+getUserInfoFromRedis);
        System.out.println("exists:"+jedis.exists(REDIS_KEY));
        System.out.println("del:"+jedis.del(REDIS_KEY));
        System.out.println("get:"+jedis.get(REDIS_KEY));
    }
}
