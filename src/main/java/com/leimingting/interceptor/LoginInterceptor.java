package com.leimingting.interceptor;

import com.leimingting.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author 小T
 * @Date 2021/5/27 12:42
 * 自定义拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        //URL除了登录请求外，其他的URL都进行拦截
        if (url.indexOf("/admin/login") >= 0) {
            return true;
        }
        //获取session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("admin");
        //判断Session中是否有用户数据，如果有，则返回true,继续向下执行
        if (user != null) {
            return true;
        }
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
