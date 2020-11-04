package com.boat.provider.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

/**
 * feign通用配置
 *
 * @author yangfan
 * @createTime 2020-11-03 21:31
 */
public class CommonCustomConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.BASIC;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("token", UUID.randomUUID().toString());
    }
}
