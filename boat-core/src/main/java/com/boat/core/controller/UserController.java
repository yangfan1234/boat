package com.boat.core.controller;


import com.boat.model.po.core.User;
import com.boat.core.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yangfan
 * @since 2020-10-07
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("listUser")
    public List<User> listUser(@RequestHeader("token") String token) {
        log.info("===收到token：{}", token);
        return userService.list();
    }

}
