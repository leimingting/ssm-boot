package com.leimingting.service.impl;

import com.leimingting.mapper.UserMapper;
import com.leimingting.pojo.User;
import com.leimingting.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/25 14:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
