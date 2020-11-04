package com.boat.core.service.impl;

import com.boat.model.po.core.User;
import com.boat.core.dao.UserMapper;
import com.boat.core.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yangfan
 * @since 2020-10-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
