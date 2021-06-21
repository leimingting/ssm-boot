package com.leimingting.service;

import com.leimingting.pojo.BaseDict;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/26 21:12
 */
public interface BaseDictService {

    /**
     * 根据类别代码查询
     *
     * @param typeCode
     * @return
     */
    List<BaseDict> findBaseDictByTypeCode(String typeCode);
}
