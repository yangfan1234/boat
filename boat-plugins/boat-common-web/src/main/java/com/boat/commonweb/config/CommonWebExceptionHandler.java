package com.boat.commonweb.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * web层全局异常处理
 *
 * @author yangfan
 * @createTime 2020-11-05 22:50
 */
@RestControllerAdvice
public class CommonWebExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object handleException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        return map;
    }
}
