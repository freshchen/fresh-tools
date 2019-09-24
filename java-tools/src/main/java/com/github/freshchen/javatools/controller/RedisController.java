package com.github.freshchen.javatools.controller;


import com.github.freshchen.javatools.pojo.request.OneRequest;
import com.github.freshchen.javatools.pojo.request.ThreeRequest;
import com.github.freshchen.javatools.pojo.request.TwoRequest;
import com.github.freshchen.javatools.pojo.response.OneResponse;
import com.github.freshchen.javatools.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @anthor LingChen
 * @create 9/24/2019 1:53 PM
 * @Description
 */
@RestController
@RequestMapping("/redis/")
@Api(value = "/redis/", tags = "Redis操作工具")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/redis/set/")
    @ApiOperation(value = "增/改", notes = "request.el1(key) request.el2(value)")
    public OneResponse<String> set(@RequestBody TwoRequest<String, String> request) {
        return new OneResponse<>(redisUtil.set(request.getEl(), request.getE2()));
    }

    @PostMapping("/redis/set/expire")
    @ApiOperation(value = "增/改(指定过期时间)", notes = "request.el1(key) request.el2(value) request.el3(expire time)")
    public OneResponse<String> setWithTime(@RequestBody ThreeRequest<String, String, Long> request) {
        return new OneResponse<>(redisUtil.set(request.getEl1(), request.getEl2(), request.getEl3()));
    }

    @PostMapping("/redis/get/")
    @ApiOperation(value = "查key的值", notes = "request.el1(key)")
    public OneResponse<Object> get(@RequestBody OneRequest<String> request) {
        return new OneResponse<>(redisUtil.get(request.getEl()));
    }

    @PostMapping("/redis/get/expire")
    @ApiOperation(value = "查key过期时间", notes = "request.el1(key)")
    public OneResponse<Long> getExpire(@RequestBody OneRequest<String> request) {
        return new OneResponse<>(redisUtil.getExpire(request.getEl()));
    }
}
