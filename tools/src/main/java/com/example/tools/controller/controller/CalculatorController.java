package com.example.tools.controller.controller;

import com.example.tools.platform.model.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

/**
 * @author darcy
 * @since 2020/11/12
 **/
@RestController
@RequestMapping("/calculator")
@Api(value = "/calculator/", tags = "计算器")
public class CalculatorController {

    @GetMapping("/sum")
    @ApiOperation(value = "求和", notes = "求和")
    public JsonResult<Long> sum(@RequestParam(name = "nums") String nums) {
        long sum = Stream.of(nums.split(","))
                .map(Long::valueOf)
                .mapToLong(Long::longValue)
                .sum();
        return JsonResult.ok(sum);
    }
}
