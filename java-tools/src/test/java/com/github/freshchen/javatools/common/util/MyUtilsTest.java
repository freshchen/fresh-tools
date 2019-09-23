package com.github.freshchen.javatools.common.util;

import com.github.freshchen.javatools.structure.VVVNode;
import com.github.freshchen.javatools.util.MyUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void greedyPlan() {
        List <VVVNode <String, Integer, Integer>> list = Arrays.asList(
                new VVVNode <>("java", 50, 60),
                new VVVNode <>("python", 20, 30),
                new VVVNode <>("shell", 10, 10),
                new VVVNode <>("php", 1125, 35),
                new VVVNode <>("scala", 1160, 45),
                new VVVNode <>("cpp", 1170, 50),
                new VVVNode <>("js", 1140, 55)
        );
        System.out.println(utils.greedyPlan(list, 100, 5));;
    }

    @Test
    public void greedyPlan1() {
        List <VVVNode <String, Integer, Integer>> list = Arrays.asList(
                new VVVNode <>("java", 50, 60),
                new VVVNode <>("python", 20, 30),
                new VVVNode <>("shell", 10, 10),
                new VVVNode <>("php", 1025, 35),
                new VVVNode <>("scala", 1160, 45),
                new VVVNode <>("cpp", 1570, 50),
                new VVVNode <>("js", 1840, 55)
        );
        System.out.println(utils.greedyPlan(list, 1000, 5));;
    }

    @Test
    public void greedyPlan2() {
        List <VVVNode <String, Integer, Integer>> list = Arrays.asList(
                new VVVNode <>("java", 50, 60),
                new VVVNode <>("python", 20, 30),
                new VVVNode <>("shell", 10, 10),
                new VVVNode <>("php", 1125, 35),
                new VVVNode <>("scala", 1160, 45),
                new VVVNode <>("cpp", 1170, 50),
                new VVVNode <>("js", 1140, 55)
        );
        System.out.println(utils.greedyPlan(list, 10000, 100));;
    }
}