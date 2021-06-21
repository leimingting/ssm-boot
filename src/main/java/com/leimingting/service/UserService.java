package com.leimingting.service;

import com.leimingting.pojo.User;

import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/25 14:44
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User login(String username, String password);

    List<User> list();
}
