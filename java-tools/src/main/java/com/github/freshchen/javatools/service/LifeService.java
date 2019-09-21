package com.github.freshchen.javatools.service;

import com.github.freshchen.javatools.pojo.response.MapResponse;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 10:37
 * @Author: Ling Chen
 * @Description:
 */
public interface LifeService {

    MapResponse getDate(long timestamp);

    MapResponse getDate();
}
