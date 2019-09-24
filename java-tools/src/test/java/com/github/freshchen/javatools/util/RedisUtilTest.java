package com.github.freshchen.javatools.util;

import com.github.freshchen.javatools.constant.StrConstants;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import redis.embedded.RedisServer;

import java.io.IOException;


/**
 * @program: fresh-tools
 * @Date: 2019/9/24 21:08
 * @Author: Ling Chen
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class RedisUtilTest {

    @Autowired
    RedisUtil util;

    static RedisServer redisServer;

    @BeforeClass
    public static void setUp() throws Exception {
        redisServer = new RedisServer(6379);
        redisServer.start();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        redisServer.stop();
    }

    @Test
    public void expire() throws InterruptedException {
        Assert.assertEquals(StrConstants.SUCCESS.getValue(), util.set("name", "wang"));
        util.expire("name", 100);
        Thread.sleep(100);
        Assert.assertNotEquals("wang", util.get("name"));
    }

    @Test
    public void hasKey() {
    }

    @Test
    @Transactional
    @Rollback()
    public void set() throws IOException {
        Assert.assertEquals(StrConstants.SUCCESS.getValue(), util.set("name", "wang"));
    }

    @Test
    public void get() {
    }

    @Test
    public void testSet() {
    }

    @Test
    public void incr() {
    }

    @Test
    public void decr() {
    }
}