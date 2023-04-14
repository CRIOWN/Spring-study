package com.criown.config;

import com.criown.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//该注解也会被spring容器托管 类似于@Component
//代表这是一个配置类，== beans.xml
@Configuration
@Import(CriownConfig2.class)
public class CriownConfig {

    @Bean
    public User getUser()
    {

        return new User();}
}
