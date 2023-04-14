package com.criown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    //登录
    @RequestMapping("/toLog")
    public String goLog(){


        return "login";
    }

    //完成登录
    @RequestMapping("/login")
    public String log(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session){
        //将用户信息存在session中
        System.out.println("log::"+username+":"+password);
        session.setAttribute("userLogInfo",username);
        System.out.println("登录");
        return "main";
    }

    @RequestMapping("/main")
    public String noLog(){
        //将用户信息存在session中
        System.out.println("直接跳转main");
        return "main";
    }
}
