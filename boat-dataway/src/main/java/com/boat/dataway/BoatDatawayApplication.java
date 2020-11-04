package com.boat.dataway;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 整合dataway服务入口
 *
 * @author yangfan
 * @createTime 2020-10-19 09:27:26
 */
@EnableHasor
@EnableHasorWeb
@SpringBootApplication
public class BoatDatawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoatDatawayApplication.class, args);
    }

}
