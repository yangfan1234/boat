package com.boat.web.service.impl;

import com.boat.web.domain.User;
import com.boat.web.mapper.UserMapper;
import com.boat.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author yangfan
 * @createTime 2020-08-03 16:45
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.get(id);
    }
}
