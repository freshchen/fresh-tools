package com.github.freshchen.javatools.service;

import com.github.freshchen.javatools.structure.VVVNode;
import com.github.freshchen.javatools.pojo.response.MapResponse;
import com.github.freshchen.javatools.pojo.response.OneResponse;

import java.io.IOException;
import java.util.List;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 10:37
 * @Author: Ling Chen
 * @Description:
 */
public interface LifeService {

    MapResponse getDate(long timestamp);

    MapResponse getDate();

    MapResponse getWeather(String cityId) throws IOException;

    MapResponse getWeather() throws IOException;

    MapResponse getStock(List <String> list) throws IOException;

    MapResponse getStock() throws IOException;

    OneResponse <String> doubleColorBall();

    OneResponse <String> superLotto();

    OneResponse <String> greedyPlan(List <VVVNode <String, Integer, Integer>> list, int init, int times);

}
