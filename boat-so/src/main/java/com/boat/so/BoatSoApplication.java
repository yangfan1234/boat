package com.boat.so;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 微服务1-测试用
 * @author yangfan
 * @createTime 2020-11-03 09:48:01
 */
@ComponentScan(basePackages = {"com.boat.so", "com.boat.provider"})
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.boat.so.dao"})
public class BoatSoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoatSoApplication.class, args);
    }

}
