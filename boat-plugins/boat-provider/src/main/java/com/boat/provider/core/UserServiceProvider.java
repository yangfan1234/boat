package com.boat.provider.core;

import com.boat.model.po.core.User;
import com.boat.provider.config.CommonCustomConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Collections;
import java.util.List;

/**
 * 用户服务
 *
 * @author yangfan
 * @createTime 2020-11-03 20:35
 */
@Component
@FeignClient(name = "boat-core",
        fallback = UserServiceProvider.DefaultUserServiceFallBack.class,
        configuration = CommonCustomConfig.class)
public interface UserServiceProvider {

    /**
     * 调用用户列表
     *
     * @return java.util.List
     * @author yangfan
     * @param token  token
     * @createTime 2020-11-03 09:01:48
     */
    @GetMapping("/user/listUser")
    List<User> listUser(@RequestHeader("token") String token);

    @Slf4j
    @Component
    class DefaultUserServiceFallBack implements UserServiceProvider {

        @Override
        public List<User> listUser(String token) {
            log.info("调用用户列表降级..");
            return Collections.EMPTY_LIST;
        }
    }
}
