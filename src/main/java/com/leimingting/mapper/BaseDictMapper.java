package com.leimingting.mapper;

import com.leimingting.pojo.BaseDict;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/26 20:30
 */
@Repository
public interface BaseDictMapper {
    List<BaseDict> selectBaseDictByTypeCode(String typeCode);
}
