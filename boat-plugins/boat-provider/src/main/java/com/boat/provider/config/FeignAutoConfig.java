package com.boat.provider.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * 启动feign
 *
 * @author yangfan
 * @createTime 2020-11-03 20:32
 */
@Configuration
@EnableFeignClients("com.boat.provider")
public class FeignAutoConfig {
}
