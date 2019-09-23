package com.github.freshchen.javatools.controller;

import com.github.freshchen.javatools.pojo.request.OneRequest;
import com.github.freshchen.javatools.pojo.request.TextRequest;
import com.github.freshchen.javatools.pojo.response.MapResponse;
import com.github.freshchen.javatools.pojo.response.OneResponse;
import com.github.freshchen.javatools.service.LifeService;
import io.swagger.annotations.Api;
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
@Api(value = "/life/", tags = "日常生活娱乐工具")
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
        return lifeService.getStock(request.getEl());
    }

    @GetMapping("/lottery/doubleColorBall")
    OneResponse <String> doubleColorBall() throws IOException {
        return lifeService.doubleColorBall();
    }

    @GetMapping("/lottery/superLotto")
    OneResponse <String> superLotto() throws IOException {
        return lifeService.superLotto();
    }

}
