package com.github.freshchen.javatools.util;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 10:53
 * @Author: Ling Chen
 * @Description:
 */
public class MyUtilsTest {

    private MyUtils utils;

    @Before
    public void setUp() throws Exception {
        utils = new MyUtils();
    }

    @Test
    public void getDate() {
        System.out.println(utils.getDate(System.currentTimeMillis()));
    }

    @Test
    public void getTodayWeather() throws IOException {
        System.out.println(utils.getWeather("101020900"));
    }
}