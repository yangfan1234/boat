package com.boat.web.controller;

import com.boat.web.domain.User;
import com.boat.web.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
 * @author yangfan
 * @createTime 2020-08-03 15:58
 */
@RestController
@RequestMapping("user")
@Api("用户接口")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("get/{id}")
    @ApiOperation(value = "获取用户", notes = "根据用户主键获取用户信息", response = User.class)
    public User getUser(@PathVariable Integer id, HttpServletRequest request) {
        //System.out.println("=================" + request.getParameter("boat"));
        throw new RuntimeException("用户接口挂了");
        //return userService.selectById(id);
    }

}
