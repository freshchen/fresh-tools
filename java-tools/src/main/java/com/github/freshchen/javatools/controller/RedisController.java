package com.github.freshchen.javatools.controller;


import com.github.freshchen.javatools.pojo.OneMessage;
import com.github.freshchen.javatools.pojo.ThreeMessage;
import com.github.freshchen.javatools.pojo.TwoMessage;
import com.github.freshchen.javatools.pojo.request.TwoRequest;
import com.github.freshchen.javatools.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/key/get/all/")
    @ApiOperation(value = "Key 查所有key和值")
    public OneMessage<Map<String, Object>> keysAndValues() {
        return new OneMessage<>(redisUtil.keysAndValues());
    }

    @PostMapping("/key/get/values")
    @ApiOperation(value = "Key 查指定key的值", notes = "request.e1(keys)")
    public OneMessage<Map<String, Object>> values(@RequestBody OneMessage<List<String>> request) {
        return new OneMessage<>(redisUtil.keysAndValues(request.getEl()));
    }

    @PostMapping("/key/del/")
    @ApiOperation(value = "Key 删除指定keys", notes = "request.e1(keys)")
    public OneMessage<String> delete(@RequestBody OneMessage<List<String>> request) {
        return new OneMessage<>(redisUtil.delete(request.getEl()));
    }

    @PostMapping("/string/add/")
    @ApiOperation(value = "String 增/改", notes = "request.e1(key) request.e2(value)")
    public OneMessage<String> set(@RequestBody TwoRequest<String, String> request) {
        return new OneMessage<>(redisUtil.set(request.getEl(), request.getE2()));
    }

    @PostMapping("/hash/add/")
    @ApiOperation(value = "Hash 批量增/改", notes = "request.e1(key) request.e2(entry(item,value))")
    public OneMessage<String> setHashs(@RequestBody TwoRequest<String, Map<String, String>> request) {
        return new OneMessage<>(redisUtil.hmset(request.getEl(), request.getE2()));
    }

    @PostMapping("/hash/add/item")
    @ApiOperation(value = "Hash 增/改指定Hash表", notes = "request.e1(key) request.e2(item) request.e3(value)")
    public OneMessage<String> setHashItem(@RequestBody ThreeMessage<String, String, String> request) {
        return new OneMessage<>(redisUtil.hset(request.getE1(), request.getE2(), request.getE3()));
    }

    @PostMapping("/hash/del/item")
    @ApiOperation(value = "Hash 删除指定items", notes = "request.e1(key) request.e2(item)")
    public OneMessage<String> delHashItem(@RequestBody TwoMessage<String, String> request) {
        return new OneMessage<>(redisUtil.hdel(request.getEl(), request.getE2()));
    }

    @PostMapping("/set/add/item")
    @ApiOperation(value = "Set 增/改指定items", notes = "request.e1(key) request.e2(items)")
    public OneMessage<String> setSetItem(@RequestBody TwoMessage<String, String> request) {
        return new OneMessage<>(redisUtil.sSet(request.getEl(), request.getE2()));
    }

    @PostMapping("/set/del/item")
    @ApiOperation(value = "Set 删除指定items", notes = "request.e1(key) request.e2(items)")
    public OneMessage<Long> delSetItem(@RequestBody TwoMessage<String, List<String>> request) {
        return new OneMessage<>(redisUtil.sRemove(request.getEl(), request.getE2()));
    }
}
