package com.leimingting.service.impl;

import com.leimingting.mapper.BaseDictMapper;
import com.leimingting.pojo.BaseDict;
import com.leimingting.service.BaseDictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 小T
 * @Date 2021/5/26 21:13
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Resource
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> findBaseDictByTypeCode(String typeCode) {
        return baseDictMapper.selectBaseDictByTypeCode(typeCode);
    }
}
