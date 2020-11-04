package com.boat.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web层配置
 *
 * @author yangfan
 * @createTime 2020-08-03 16:05
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 国际化配置
     *
     * @author yangfan
     * @createTime 2020-08-03 06:16:19
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
