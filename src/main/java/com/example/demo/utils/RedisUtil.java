package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author QQQ
 */
@Component

public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;

    /**
     * <p>
     * 向redis存入key和value,并释放连接资源
     * </p>
     * <p>
     * 如果key已经存在 则覆盖
     * </p>
     *
     * @param key
     * @param value
     * @return 成功 返回OK 失败返回 0
    */
    public String set(String key, String value) {
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                return jedis.set(key, value);
            } catch (Exception e) {
                e.printStackTrace();
                return "0";
            }finally {
                if(jedis !=null){
                    jedis.close();
                }
            }
    }

    /**
     * 通过key获取储存在redis中的value
     * @param key
     * @return 获得的值
     */
    public String get(String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(jedis !=null){
                jedis.close();
            }
        }
    }

    /**
     * <p>
     * 删除指定的key,也可以传入一个包含key的数组
     * </p>
     *
     * @param keys 一个key 也可以使 string 数组
     * @return 返回删除成功的个数
     */
    public Long del(String... keys){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.del(keys);
        }catch (Exception e){
            e.printStackTrace();
            return 0L;
        }finally {
            if(jedis !=null){
                jedis.close();
            }
        }
    }

    /**
     * <p>
     * 判断key是否存在
     * </p>
     *
     * @param key
     * @return true OR false
     */
    public boolean exists(String key){
        Jedis jedis = null;
        try{
            jedis= jedisPool.getResource();
            return jedis.exists(key);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            if(jedis !=null){
                jedis.close();
            }
        }
    }

    /**
     * <p>
     * 为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除。
     * </p>
     *
     * @param key
     * @param value
     *            过期时间，单位：秒
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public Long expire(String key,int value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.expire(key,value);
        }catch(Exception e){
            e.printStackTrace();
            return 0L;
        }finally {
            if(jedis !=null){
                jedis.close();
            }
        }
    }

    /**
     * <p>
     * 以秒为单位，返回给定 key 的剩余生存时间
     * </p>
     *
     * @param key
     * @return 当 key 不存在时，返回 -2 。当 key 存在但没有设置剩余生存时间时，返回 -1 。否则，以秒为单位，返回 key
     *         的剩余生存时间。 发生异常 返回 0
     */
    public Long ttl(String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.ttl(key);
        }catch(Exception e){
           e.printStackTrace();
           return 0L;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

}
