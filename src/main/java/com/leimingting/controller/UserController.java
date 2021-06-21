package com.leimingting.controller;

import com.leimingting.pojo.User;
import com.leimingting.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author 小T
 * @Date 2021/5/25 14:46
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/goLogin")
    public String goLogin() {
        return "login";
    }


    @PostMapping("/login")
    public String login(String username,String password, HttpSession session) {
        User admin = userService.login(username,password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "customer";
        } else {
            return "redirect:/admin/goLogin";
        }
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/admin/goLogin";
    }
}
