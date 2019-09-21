package com.github.freshchen.javatools.service.impl;

import com.github.freshchen.javatools.pojo.response.MapResponse;
import com.github.freshchen.javatools.service.LifeService;
import com.github.freshchen.javatools.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
