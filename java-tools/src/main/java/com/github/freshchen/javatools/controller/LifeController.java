package com.github.freshchen.javatools.controller;

import com.github.freshchen.javatools.pojo.request.OneRequest;
import com.github.freshchen.javatools.pojo.request.TextRequest;
import com.github.freshchen.javatools.pojo.response.MapResponse;
import com.github.freshchen.javatools.service.LifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class LifeController {

    @Autowired
    private LifeService lifeService;

    @PostMapping("/time/")
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

    @PostMapping("/weather/")
    public MapResponse getWeather() throws IOException {
        return lifeService.getWeather();
    }

    @PostMapping("/weather/cityId/")
    public MapResponse getWeather(@RequestBody TextRequest request) throws IOException {
        return lifeService.getWeather(request.getText());
    }

    @PostMapping("/stock/id/")
    MapResponse getStock(@RequestBody OneRequest<List<String>> request) throws IOException {
        return lifeService.getStock(request.getElement());
    }

    @PostMapping("/stock/")
    MapResponse getStock() throws IOException {
        return lifeService.getStock();
    }
}
