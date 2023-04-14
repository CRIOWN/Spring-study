package com.criown.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {
   // @Value("可通过value注解赋值")
    public String name ;
}
