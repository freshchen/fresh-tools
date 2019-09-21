package com.github.freshchen.javatools.service.impl;

import com.github.freshchen.javatools.common.constant.StrConstants;
import com.github.freshchen.javatools.pojo.response.MapResponse;
import com.github.freshchen.javatools.service.LifeService;
import com.github.freshchen.javatools.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 11:45
 * @Author: Ling Chen
 * @Description:
 */
@Service
public class LifeServiceImpl implements LifeService {

    @Autowired
    private MyUtils utils;

    @Override
    public MapResponse getDate(long timestamp) {
        return new MapResponse <String, String>(utils.getDate(timestamp));
    }

    @Override
    public MapResponse getDate() {
        return new MapResponse <String, String>(utils.getDate(System.currentTimeMillis()));
    }

    @Override
    public MapResponse getWeather(String cityId) throws IOException {
        Map weather = utils.getWeather(cityId);
        return new MapResponse <String, Map>(weather);
    }

    @Override
    public MapResponse getWeather() throws IOException {
        Map weather = new HashMap();
        weather.put("上海", utils.getWeather(StrConstants.SHANG_HAI.getValue()));
        weather.put("北京", utils.getWeather(StrConstants.BEI_JING.getValue()));
        weather.put("泰兴", utils.getWeather(StrConstants.TAI_XING.getValue()));
        weather.put("舟山", utils.getWeather(StrConstants.ZHOU_SHAN.getValue()));
        weather.put("松江", utils.getWeather(StrConstants.SHANG_HAI.getValue()));
        return new MapResponse <String, Map>(weather);
    }
}
