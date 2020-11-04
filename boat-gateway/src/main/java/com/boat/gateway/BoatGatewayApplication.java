package com.boat.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关启动入口
 *
 * @author yangfan
 * @createTime 2020-10-09 09:33:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BoatGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoatGatewayApplication.class, args);
    }

}
