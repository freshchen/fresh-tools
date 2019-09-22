package com.github.freshchen.javatools.controller;

import com.github.freshchen.javatools.common.structure.VVVNode;
import com.github.freshchen.javatools.pojo.request.OneRequest;
import com.github.freshchen.javatools.pojo.request.TextRequest;
import com.github.freshchen.javatools.pojo.request.ThreeRequest;
import com.github.freshchen.javatools.pojo.response.MapResponse;
import com.github.freshchen.javatools.pojo.response.OneResponse;
import com.github.freshchen.javatools.service.LifeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @program: fresh-tools
 * @Date: 2019/9/21 11:54
 * @Author: Ling Chen
 * @Description:
 */
@RestController
@RequestMapping("/life/")
@Api(value = "/life/", tags = "日常工具")
public class LifeController {

    @Autowired
    private LifeService lifeService;

    @GetMapping("/time/")
    public MapResponse getDate() {
        return lifeService.getDate();
    }

    /**
     * stamp can be get from System.currentTimeMillis()
     *
     * @param request
     * @return
     */
    @PostMapping("/time/stamp/")
    public MapResponse getDate(@RequestBody TextRequest request) {
        return lifeService.getDate(Long.valueOf(request.getText()));
    }

    @GetMapping("/weather/")
    public MapResponse getWeather() throws IOException {
        return lifeService.getWeather();
    }

    @PostMapping("/weather/cityId/")
    public MapResponse getWeather(@RequestBody TextRequest request) throws IOException {
        return lifeService.getWeather(request.getText());
    }

    @GetMapping("/stock/")
    MapResponse getStock() throws IOException {
        return lifeService.getStock();
    }

    @PostMapping("/stock/id/")
    MapResponse getStock(@RequestBody OneRequest <List <String>> request) throws IOException {
        return lifeService.getStock(request.getElement());
    }

    @GetMapping("/lottery/doubleColorBall")
    OneResponse <String> doubleColorBall() throws IOException {
        return lifeService.doubleColorBall();
    }

    @GetMapping("/lottery/superLotto")
    OneResponse <String> superLotto() throws IOException {
        return lifeService.superLotto();
    }

    @PostMapping("/plan/greedy/")
    @ApiOperation("按照成本收益指定计划")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "element1", value = "计划列表"),
            @ApiImplicitParam(name = "element1.v1", value = "计划名"),
            @ApiImplicitParam(name = "element1.v2", value = "需要资源"),
            @ApiImplicitParam(name = "element1.v3", value = "带来收益"),
            @ApiImplicitParam(name = "element2", value = "初始资源"),
            @ApiImplicitParam(name = "element3", value = "可执行计划上限"),
    })
    OneResponse <String> greedyPlan(@RequestBody ThreeRequest <List <VVVNode <String, Integer, Integer>>, Integer, Integer> request) {
        return lifeService.greedyPlan(request.getElement1(), request.getElement2(), request.getElement3());
    }
}
