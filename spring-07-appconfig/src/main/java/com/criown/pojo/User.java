package com.criown.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//注解说明该类被spring接管 注册到了容器中
@Component
public class User {
    @Value("宋天玥")
private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
