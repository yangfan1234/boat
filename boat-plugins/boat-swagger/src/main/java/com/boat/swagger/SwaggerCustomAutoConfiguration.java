package com.boat.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置
 *
 * @author yangfan
 * @createTime 2020-09-09 20:18
 */
@Configuration
@EnableOpenApi
@EnableConfigurationProperties(CustomSwaggerProperties.class)
public class SwaggerCustomAutoConfiguration {

    @Autowired
    private CustomSwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable(swaggerProperties.isEnable())
                .apiInfo(apiInfo())
                .host(swaggerProperties.getTryHost())
                .select()
                .apis(StringUtils.hasText(swaggerProperties.getBasePackage()) ?
                        RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()) :
                        RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title(swaggerProperties.getApplicationName() + " 服务接口文档")
                // 创建人信息
                .contact(new Contact("码农和诗", null, "715871480@qq.com"))
                // 版本号
                .version("项目版本: " + swaggerProperties.getApplicationVersion())
                // 描述
                .description(swaggerProperties.getApplicationDesc())
                .build();
    }
}
