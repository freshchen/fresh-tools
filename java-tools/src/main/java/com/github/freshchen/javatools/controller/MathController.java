package com.github.freshchen.javatools.controller;

import com.github.freshchen.javatools.pojo.OneMessage;
import com.github.freshchen.javatools.pojo.TwoMessage;
import com.github.freshchen.javatools.util.MyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @anthor LingChen
 * @create 9/26/2019 10:59 AM
 * @Description
 */
@RestController
@RequestMapping("/math/")
@Api(value = "/math/", tags = "数学计算工具")
public class MathController {

    @Autowired
    private MyUtils utils;

    @PostMapping("/factorial/")
    @ApiOperation(value = "求阶乘", notes = "request.e1(num)")
    OneMessage<BigInteger> factorial(@RequestBody OneMessage <Integer> request) {
        return new OneMessage <>(utils.factorial(request.getEl()));
    }

    @PostMapping("/accumulator/")
    @ApiOperation(value = "累加器", notes = "request.e1(from) request.e1(to)")
    OneMessage <Long> accumulator(@RequestBody TwoMessage<Long, Long> request) {
        return new OneMessage <>(utils.accumulator(request.getEl(), request.getE2()));
    }
}
