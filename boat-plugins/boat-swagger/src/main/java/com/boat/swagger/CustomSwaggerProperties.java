package com.boat.swagger;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * swagger配置信息
 *
 * @author yangfan
 * @createTime 2020-11-03 16:34
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "swagger.custom")
public class CustomSwaggerProperties {

    /** 是否开启，生产环境关闭 */
    private boolean enable = false;

    /** 包路径 */
    private String basePackage;

    /**
     * 项目应用名
     */
    private String applicationName;

    /**
     * 项目版本信息
     */
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    private String applicationDesc;

    /**
     * 接口调试地址
     */
    private String tryHost;

}
