package com.github.freshchen.javatools.util;

import com.github.freshchen.javatools.constant.StrConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @anthor LingChen
 * @create 4/19/2019 1:31 PM
 * @Description
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    /**
     * set expiration time for key
     *
     * @param key
     * @param time
     * @return
     */
    public String expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
            }
            return StrConstants.SUCCESS.getValue();
        } catch (Exception e) {
            e.printStackTrace();
            return StrConstants.FAILURE.getValue();
        }
    }

    /**
     * get key expiration time
     *
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.MILLISECONDS);
    }


    /**
     * judge the key exist?
     *
     * @param key
     * @return true or false
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * String
     * set key value
     *
     * @param key
     * @param value
     * @return
     */
    public String set(String key, Object value) {

        try {
            redisTemplate.opsForValue().set(key, value);
            return StrConstants.SUCCESS.getValue();
        } catch (Exception e) {
            e.printStackTrace();
            return StrConstants.FAILURE.getValue();
        }
    }

    /**
     * String
     * get the value
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * set  key value and  expire time
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    public String set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.MILLISECONDS);
            } else {
                set(key, value);
            }
            return StrConstants.SUCCESS.getValue();
        } catch (Exception e) {
            e.printStackTrace();
            return StrConstants.FAILURE.getValue();
        }
    }

    /**
     * increase
     *
     * @param key
     * @param delta
     * @return
     */
    public long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * decrease
     *
     * @param key
     * @param delta
     * @return
     */
    public long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }


}
