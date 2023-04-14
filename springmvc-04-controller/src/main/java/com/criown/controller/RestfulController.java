package com.criown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestfulController {
    //传参 .../add?a=1&b=2
    @RequestMapping("/add1")
    public String test1( int a, int b , Model model)
    {//传统风格
        int rest = a+b;
        model.addAttribute("msg","RestfulController-test1 结果为:"+rest);

        return "test"; // 自动拼接为 WEB_INF/jsp/test.jsp 页面资源存储位置
    }

    @RequestMapping("/add2/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable int b , Model model)
    {//传统风格
        int rest = a+b;
        model.addAttribute("msg","RestfulController-test1 结果为:"+rest);

        return "test"; // 自动拼接为 WEB_INF/jsp/test.jsp 页面资源存储位置
    }
}
