package com.example.workeachweek.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object login = session.getAttribute("Login");

        if(login!=null) {
            return true;
        }else {
            request.setAttribute("msg", "请先登录!");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }
}
