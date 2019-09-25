package com.github.freshchen.javatools.util;

import com.github.freshchen.javatools.constant.StrConstants;
import org.junit.AfterClass;
import org.junit.Assert;
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
        Assert.assertEquals(false, util.hasKey("age"));
        Assert.assertEquals(StrConstants.SUCCESS.getValue(), util.set("age", "111"));
        Assert.assertEquals(true, util.hasKey("age"));
    }

    @Test
    public void set() throws IOException {
        Assert.assertEquals(StrConstants.SUCCESS.getValue(), util.set("name", "wang"));
    }

    @Test
    public void setWithTime() throws IOException, InterruptedException {
        Assert.assertEquals(StrConstants.SUCCESS.getValue(), util.set("name", "wang", 100));
        Thread.sleep(1000);
        Assert.assertNotEquals("wang", util.get("name"));
    }

    @Test
    public void get() {
        Assert.assertEquals(StrConstants.SUCCESS.getValue(), util.set("name", "wang"));
        Assert.assertEquals("wang", util.get("name"));
    }


    @Test
    public void incr() {
        Assert.assertEquals(StrConstants.SUCCESS.getValue(), util.set("year", 111));
        Assert.assertEquals(112, util.incr("year",1));
    }

    @Test
    public void decr() {
        Assert.assertEquals(StrConstants.SUCCESS.getValue(), util.set("year", 111));
        Assert.assertEquals(110, util.decr("year",1));
    }

    @Test
    public void hget() {
        System.out.println(util.hget("name","1"));
    }

    @Test
    public void hmget() {
        System.out.println(util.hmget("name"));
    }

    @Test
    public void hset() {
        System.out.println(util.hset("name","11","22"));
    }

    @Test
    public void hdel() {
        System.out.println(util.hdel("name","11"));
    }

    @Test
    public void hHasKey() {
        System.out.println(util.hHasKey("name","11"));
    }

    @Test
    public void hincr() {
        System.out.println(util.hincr("name","11",22));
    }

    @Test
    public void hdecr() {
        System.out.println(util.hdecr("name","11",22));
    }

    @Test
    public void sGet() {
        System.out.println(util.sGet("name"));
    }

    @Test
    public void sHasKey() {
        System.out.println(util.sHasKey("name","11"));
    }

}