package com.leimingting.pojo;

import lombok.Data;

/**
 * @Author 小T
 * @Date 2021/5/25 14:37
 * 系统信息表
 */
@Data
public class User {
    private Integer id;
    private String code;
    private String name;
    private String password;
    private String state;
}
