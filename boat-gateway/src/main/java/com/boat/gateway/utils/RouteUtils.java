package com.boat.gateway.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

/**
 * 路由工具类
 *
 * @author yangfan
 * @createTime 2020-11-05 13:49
 */
public class RouteUtils {

    public static void main(String[] args) throws URISyntaxException {
        RouteDefinition definition = new RouteDefinition();
        definition.setId("boat-web");
        definition.setUri(new URI("lb://boat-web"));
        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        predicateDefinition.addArg("Pattern", "/web/**");
        definition.setPredicates(Collections.singletonList(predicateDefinition));
        System.out.println(JSONObject.toJSONString(definition));
        // {"filters":[],"id":"boat-web","order":0,"predicates":[{"args":{"Pattern":"/web/**"},"name":"Path"}],"uri":"lb://boat-web"}
    }
}
