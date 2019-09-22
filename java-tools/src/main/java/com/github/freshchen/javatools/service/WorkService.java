package com.github.freshchen.javatools.service;

import com.github.freshchen.javatools.common.structure.VVVNode;
import com.github.freshchen.javatools.pojo.response.OneResponse;

import java.util.List;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 10:37
 * @Author: Ling Chen
 * @Description:
 */
public interface WorkService {

    OneResponse <String> greedyPlan(List <VVVNode <String, Integer, Integer>> list, int init, int times);

}
