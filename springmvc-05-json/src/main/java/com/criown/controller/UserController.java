package com.criown.controller;


import com.criown.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/j1")
    @ResponseBody//不走视图解析器 会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user =new User(1,"宋天玥","男");
        String str= mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    @ResponseBody//不走视图解析器 会直接返回一个字符串
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userlist = new ArrayList<>();

        User user1 =new User(1,"宋天玥","男");
        User user2 =new User(2,"王栗","女");
        User user3 =new User(3,"宋天玥","男");
        User user4 =new User(4,"王栗","女");
        User user5 =new User(5,"宋天玥","男");
        userlist.add(user1);
        userlist.add(user2);
        userlist.add(user3);
        userlist.add(user4);
        userlist.add(user5);
        String str= mapper.writeValueAsString(userlist);
        return str;
    }

    @RequestMapping("/j3")
    @ResponseBody//不走视图解析器 会直接返回一个字符串
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String str= mapper.writeValueAsString( sdf.format(date));
        return str;
    }

}
