package com.boat.so.controller;

import com.boat.model.po.core.User;
import com.boat.provider.core.UserServiceProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试
 *
 * @author yangfan
 * @createTime 2020-11-03 12:38
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserServiceProvider userServiceProvider;

    @RequestMapping("test")
    public String test() {
        return "SUCCESS";
    }

    @ApiOperation("测试feign调用")
    @GetMapping("listUserFromCore")
    public List<User> listUserFromCore() {
        return userServiceProvider.listUser("123");
    }

}
