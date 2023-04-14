package com.criown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//spring接管 所有被这样注解的类中所有方法 如果返回值是String ，并且有具体的页面可以跳转 就会被视图解析器解析
@Controller
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test2(Model model)
    {
        model.addAttribute("msg","ControllerTest2-t2");

        return "test"; // 自动拼接为 WEB_INF/jsp/test.jsp 页面资源存储位置
    }
    @RequestMapping("/t3")
    public String test3(Model model)
    {
        model.addAttribute("msg","ControllerTest2-t3");

        return "test"; // 自动拼接为 WEB_INF/jsp/test.jsp 页面资源存储位置
    }
}
