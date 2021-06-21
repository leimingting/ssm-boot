package com.leimingting.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/26 20:36
 */
@Data
public class Page<T> {
    private int total;//总条数
    private int page;//当前页
    private int size;//没页数
    private List<T> rows;//结果集
}
