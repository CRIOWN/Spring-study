package com.criown.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//注解生效 spring自动扫描 不用bean配置
@Controller
public class HelloController {
    @RequestMapping("/h1")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello! springmvc with annotation");
        //视图解析器处理return
        return "hello";
    }
}
