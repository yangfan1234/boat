package com.boat.gateway.config;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义路由规则 通过每天的起始和结束时间来控制访问
 *
 * @author yangfan
 * @createTime 2020-11-04 22:00
 */
@Component
public class BoatRoutePredicateFactory extends AbstractRoutePredicateFactory<BoatRoutePredicateConfig> {

    public BoatRoutePredicateFactory() {
        super(BoatRoutePredicateConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(BoatRoutePredicateConfig config) {
        return exchange -> {
            LocalTime now = LocalTime.now();
            return now.isAfter(config.getStartTime()) && now.isBefore(config.getEndTime());
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("startTime", "endTime");
    }
}
