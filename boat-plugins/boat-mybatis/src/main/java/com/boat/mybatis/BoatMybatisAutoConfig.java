package com.boat.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis自动配置
 * @author yangfan
 * @createTime 2020-07-19 19:05
 */
@Configuration
@MapperScan({"com.boat.*.mapper*"})
public class BoatMybatisAutoConfig {
}
