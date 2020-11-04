package com.boat.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 管理前端控制器
 *
 * @author yangfan
 * @createTime 2020-10-07 19:01
 */
@Api(value = "管理端服务", tags = "这个一个管理端服务，用于测试")
@RestController
@RequestMapping("admin")
@RefreshScope
public class AdminController {

    @Value("${refresh}")
    private String val;

    @ApiIgnore
    @RequestMapping("test")
    public String test() {
        return "SUCCESS";
    }

    @ApiOperation(value = "测试配置中心刷新配置", tags = "一个用来测试配置中心刷新参数的接口，用于测试")
    @GetMapping("refresh")
    public String configRefresh() {
        return val;
    }
}
