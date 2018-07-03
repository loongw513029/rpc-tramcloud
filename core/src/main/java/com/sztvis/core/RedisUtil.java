package com.sztvis.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/5 下午4:30
 */

@Component
public class RedisUtil {

    @Autowired
    private JedisPool jedisPool;

    public void set(String key, String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        }
        catch (Exception ex){
            Exception ex2 =ex;
        }finally {
            //返还到连接池
            jedis.close();
        }
    }

    public  String get(String key) throws Exception  {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        }
        catch (Exception ex){
            Exception e = ex;
            return null;
        }
        finally {
            //返还到连接池
            jedis.close();
        }
    }

    public  boolean exists(String key) {
        Jedis jedis=null ;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } finally {
            jedis.close();
        }
    }

    public Long delete(String key) {
        Jedis jedis=null ;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    public static void main(String [] args){
        String uuid= UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        System.out.println(uuid);
    }
}
