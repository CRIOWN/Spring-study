package com.criown.controller;


import com.criown.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@ControllerAdvice
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //用@RequestParam表示从前段接收的参数
        System.out.println("t1::接收到参数为："+name);
        //2. 返回
        model.addAttribute("msg",name);
        return "test";
    }

    @GetMapping("/t2")
    public String usertest(User user, Model model){
        //用@RequestParam表示从前段接收的参数
        System.out.println("t2::接收到参数为："+user);
        //2. 返回
       model.addAttribute("msg",user);
        return "test";
    }
}
