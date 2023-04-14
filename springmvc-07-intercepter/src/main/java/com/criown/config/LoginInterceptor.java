package com.criown.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        System.out.println("==========Interceptor===========");
       if(session.getAttribute("userLogInfo")!=null){

           System.out.println("session不为空");
           return true;
       }
       if(request.getRequestURI().contains("login")){
           System.out.println("检测到login");
           return true;
       }

        System.err.println("触发拦截 自动跳转");
       //拦截
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
       return false;
        // return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
