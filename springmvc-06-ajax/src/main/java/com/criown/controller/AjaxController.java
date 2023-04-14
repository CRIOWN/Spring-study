
package com.criown.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    //用户名admin 密码123456
    @RequestMapping("/a1")
    public String ajax1(String name) {
        System.out.println("hello");
        System.out.println("a1:param:"+name);

         if ("admin".equals(name)){

             return "ok";
         }else{

             return "error";
         }
     }

}