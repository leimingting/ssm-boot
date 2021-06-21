package com.leimingting.controller;

import com.leimingting.pojo.BaseDict;
import com.leimingting.pojo.Customer;
import com.leimingting.pojo.User;
import com.leimingting.service.BaseDictService;
import com.leimingting.service.CustomerService;
import com.leimingting.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 小T
 * @Date 2021/6/5 16:03
 */
@Controller
public class JSONController {
    @Resource
    private UserService userService;

    @ResponseBody
    @PostMapping("/jsonType")
    public List<User> jsonType(){
        List<User> list = userService.list();
        return list;
    }
}
