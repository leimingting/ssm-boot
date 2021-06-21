package com.leimingting.controller;

import com.leimingting.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 小T
 * @Date 2021/6/4 20:25
 */
@RestController
@RequestMapping(value = "/my",produces ="text/html;charset=utf-8" )
public class MyController {

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id) {
        return "select id=" + id;
    }

    @PostMapping("/user")
    public String insUser(@RequestBody User user) {
        return "add user" + user;
    }

    @PutMapping( "/user")
    public String updUser(@RequestBody User user){
        user.setName("刘贵君");
        return "update user"+user;
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id){
        return "delete id="+id;
    }

}
