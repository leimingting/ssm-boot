package com.leimingting.mapper;

import com.leimingting.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/25 14:40
 */
@Repository
public interface UserMapper {
    User login(@Param("username") String username, @Param("password") String password);

    List<User> list();
}
