package com.boat.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 项目启动入口配置类
 * @author yangfan
 * @createTime 2020-08-03 05:17:54
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.boat.web.mapper")
public class BoatWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoatWebApplication.class, args);
    }

}
