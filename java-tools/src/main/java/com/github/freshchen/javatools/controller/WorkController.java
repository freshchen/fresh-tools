package com.github.freshchen.javatools.controller;

import com.github.freshchen.javatools.common.structure.VVVNode;
import com.github.freshchen.javatools.pojo.request.ThreeRequest;
import com.github.freshchen.javatools.pojo.response.OneResponse;
import com.github.freshchen.javatools.service.WorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("按照成本收益制定计划")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "element1", value = "计划列表"),
            @ApiImplicitParam(name = "element1.v1", value = "计划名"),
            @ApiImplicitParam(name = "element1.v2", value = "需要资源"),
            @ApiImplicitParam(name = "element1.v3", value = "带来收益"),
            @ApiImplicitParam(name = "element2", value = "初始资源"),
            @ApiImplicitParam(name = "element3", value = "可执行计划上限"),
    })
    OneResponse <String> greedyPlan(@RequestBody ThreeRequest <List <VVVNode <String, Integer, Integer>>, Integer, Integer> request) {
        return workService.greedyPlan(request.getElement1(), request.getElement2(), request.getElement3());
    }
}
