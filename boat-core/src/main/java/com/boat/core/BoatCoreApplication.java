package com.boat.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 项目启动入口
 *
 * @author yangfan
 * @createTime 2020-10-07 05:50:37
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.boat.core.dao"})
public class BoatCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoatCoreApplication.class, args);
    }

}
