package com.example.tools.controller.controller;

import com.example.tools.platform.model.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author darcy
 * @since 2020/11/12
 **/
@RestController
@RequestMapping("/calculator")
@Api(value = "/calculator/", tags = "计算器")
public class CalculatorController {

    @GetMapping("/sum")
    @ApiOperation(value = "查询所有不重要的信息", notes = "查询所有不重要的信息")
    public JsonResult<Long> findAll(List<Long> nums) {
        long sum = nums.stream()
                .mapToLong(Long::longValue)
                .sum();
        return JsonResult.ok(sum);
    }
}
