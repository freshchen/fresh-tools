package com.github.freshchen.javatools.util;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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

    RedisServer redisServer;

    @BeforeClass
    public void setUp() throws Exception {
        redisServer = new RedisServer(6379);
        redisServer.start();
    }

    @AfterClass
    public void tearDown() throws Exception {
        redisServer.stop();
    }

    @Test
    public void expire() {
    }

    @Test
    public void getExpire() {
    }

    @Test
    public void hasKey() {
    }

    @Test
    public void set() throws IOException {
        System.out.println(util.set("name", "wang"));
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