package com.it.controller;

import com.it.result.Result;
import com.it.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;

@Api(tags = "登录模块")
@RestController
public class LoginController {

    @Autowired
    private AccountService accountService;

   @ApiOperation("用户登录接口")
    @PostMapping(value = "/login", consumes = "application/x-www-form-urlencoded")
    public Result login(String username, String password) {
        //调用accountService的login方法，传入用户名和密码，获取登录令牌
        String loginToken = accountService.login(username, password);
        //创建一个HashMap，用于存放返回结果
        HashMap<String, String> result = new HashMap<>();
        //将登录令牌放入HashMap中
        result.put("token", loginToken);
       System.out.println(loginToken);
        //返回结果
        return Result.success(result);
    }

    @ApiOperation("获取当前用户信息")
    @GetMapping("/me")
    public Result getUserDetail(@ApiIgnore @RequestHeader String token) {
        //调用accountService的findLoginUser方法，传入token，获取当前用户信息
        return Result.success(accountService.findLoginUser(token));
    }

    @ApiOperation("退出登录接口")
    @GetMapping("/logout")
    public Result logout() {
        //返回结果
        return Result.success("退出登录成功");
    }
}
