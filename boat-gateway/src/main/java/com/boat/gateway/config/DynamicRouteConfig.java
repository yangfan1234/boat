package com.boat.gateway.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * 动态路由配置，结合注册中心实现动态路由
 *
 * @author yangfan
 * @createTime 2020-11-05 13:06
 */
@Slf4j
@Component
public class DynamicRouteConfig implements ApplicationEventPublisherAware {

    /**
     * 配置中心地址
     */
    @Value("${spring.cloud.nacos.config.server-addr}")
    private String serverAddr;

    /**
     * 配置ID
     */
    private static final String DATA_ID = "gateway-router";

    /**
     * 配置组
     */
    private static final String GROUP = "DEFAULT_GROUP";

    /**
     * 事件发布器
     */
    private ApplicationEventPublisher publisher;

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    @PostConstruct
    public void initDynamicRoute() {
        log.info("初始化动态路由");
        try {
            ConfigService configService = NacosFactory.createConfigService(serverAddr);
            String config = configService.getConfig(DATA_ID, GROUP, 5000);
            refreshRoute(config);
            configService.addListener(DATA_ID, GROUP, new Listener() {

                @Override
                public void receiveConfigInfo(String configInfo) {
                    refreshRoute(configInfo);
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (Exception e) {
            log.error("初始化动态路由异常：{}", e);
        }
    }

    private void refreshRoute(String configInfo) {
        if (StringUtils.isBlank(configInfo)) {
            log.info("未配置路由策略");
            return;
        }
        log.info("刷新路由策略：{}", configInfo);
        try {
            List<RouteDefinition> gatewayRouteDefinitions = JSONObject.parseArray(configInfo, RouteDefinition.class);
            gatewayRouteDefinitions.forEach(this::addRoute);
            publish();
        } catch (Exception e) {
            log.info("刷新路由策略失败：{}", e);
        }
    }

    private void addRoute(RouteDefinition definition) {
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        } catch (Exception e) {
            log.error("动态添加路由异常，路由策略：{} 异常信息：{}", definition, e);
        }
    }

    private void publish() {
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
