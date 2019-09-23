package com.github.freshchen.javatools.controller;

import com.github.freshchen.javatools.structure.VVVNode;
import com.github.freshchen.javatools.pojo.request.ThreeRequest;
import com.github.freshchen.javatools.pojo.response.OneResponse;
import com.github.freshchen.javatools.service.WorkService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: fresh-tools
 * @Date: 2019/9/22 21:39
 * @Author: Ling Chen
 * @Description:
 */
@RestController
@RequestMapping("/work/")
@Api(value = "/work/", tags = "工作中使用工具")
public class WorkController {

    @Autowired
    private WorkService workService;

    @PostMapping("/plan/greedy/")
    @ApiOperation(value = "按照成本收益制定计划", notes = "request.el1(计划列表) request.el1.v1(计划名) " +
            "request.el1.v2(需要资源) request.el1.v3(带来收益) request.el2(初始资源) request.el3(可执行计划上限)")
    OneResponse <String> greedyPlan(@RequestBody ThreeRequest <List <VVVNode <String, Integer, Integer>>, Integer, Integer> request) {
        return workService.greedyPlan(request.getEl1(), request.getEl2(), request.getEl3());
    }
}
