package com.github.freshchen.javatools.service.impl;

import com.github.freshchen.javatools.common.structure.VVVNode;
import com.github.freshchen.javatools.common.util.MyUtils;
import com.github.freshchen.javatools.pojo.response.OneResponse;
import com.github.freshchen.javatools.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 11:45
 * @Author: Ling Chen
 * @Description:
 */
@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private MyUtils utils;

    @Override
    public OneResponse <String> greedyPlan(List <VVVNode <String, Integer, Integer>> list, int init, int times) {
        return new OneResponse <>(utils.greedyPlan(list, init, times));
    }
}
