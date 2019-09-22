package com.github.freshchen.javatools.util;

import com.github.freshchen.javatools.common.util.MyUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

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
    public void getWeather() throws IOException {
        System.out.println(utils.getWeather("101020900"));
    }

    @Test
    public void getStockInfo() throws IOException {
        System.out.println(utils.getStockInfo(Arrays.asList("600900","300530")));
    }

    @Test
    public void doubleColorBall() {
        System.out.println(utils.doubleColorBall());
    }

    @Test
    public void superLotto() {
        System.out.println(utils.superLotto());
    }
}