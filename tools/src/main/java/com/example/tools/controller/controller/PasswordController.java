package com.example.tools.controller.controller;

import com.example.tools.application.service.PasswordService;
import com.example.tools.controller.checker.PasswordChecker;
import com.example.tools.persistence.model.Password;
import com.example.tools.platform.model.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author darcy
 * @since 2020/10/25
 **/
@RestController
@RequestMapping("/password")
@Api(value = "/password/", tags = "不重要的信息")
public class PasswordController {

    @Autowired
    private PasswordChecker passwordChecker;

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/find/all")
    @ApiOperation(value = "查询所有不重要的信息", notes = "查询所有不重要的信息")
    public JsonResult<List<Password>> findAll(@RequestParam("salt") String salt) {
        passwordChecker.checkSalt(salt);
        return JsonResult.ok(passwordService.findAll());
    }

    @GetMapping("/save")
    @ApiOperation(value = "保存不重要的信息", notes = "保存不重要的信息")
    public JsonResult<Void> save(@RequestParam("salt") @NotBlank String salt,
                                 @RequestParam("name") @NotBlank String name,
                                 @RequestParam("password") @NotBlank String password) {
        passwordChecker.checkSalt(salt);
        passwordService.save(name, password);
        return JsonResult.ok();
    }
}
