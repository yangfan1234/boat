package com.boat.web.service;

import com.boat.web.domain.User;

/**
 * 用户服务
 * @author yangfan
 * @createTime 2020-08-03 04:44:31
 */
public interface IUserService {

    /**
     *  根据主键查询
     * @author yangfan
     * @createTime 2020-08-03 04:43:27
     * @param id 用户主键
     * @return com.boat.web.domain.User
     */
    User selectById(Integer id);
}
