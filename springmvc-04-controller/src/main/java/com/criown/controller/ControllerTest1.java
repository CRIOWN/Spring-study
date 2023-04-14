package com.criown.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//实现接口功能 控制器 返回一个MV--model and view
@org.springframework.stereotype.Controller
@RequestMapping("/t1")
public class ControllerTest1  {
    @RequestMapping("/t2")
    public String test1(Model model)
    {
        model.addAttribute("msg","ControllerTest1");

        return "test"; // 自动拼接为 WEB_INF/jsp/test.jsp 页面资源存储位置
    }

}
