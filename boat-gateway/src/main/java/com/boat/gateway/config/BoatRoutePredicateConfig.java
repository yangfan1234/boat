package com.boat.gateway.config;

import lombok.Data;

import java.time.LocalTime;

/**
 * 自定义路由配置
 *
 * @author yangfan
 * @createTime 2020-11-04 22:01
 */
@Data
public class BoatRoutePredicateConfig {

    private LocalTime startTime;
    private LocalTime endTime;
}
