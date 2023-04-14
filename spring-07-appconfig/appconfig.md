# Spring-08-全面注解
通过config类来代替xml实现beans的功能
```java
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
```
```java
public class Mytest
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CriownConfig.class);
        User user = (User) context.getBean("getUser");
        System.out.println(user.getName());
    }
}
```
使用框架相同 beans.xml使用ClassPathXmlApplicationContext("beans.xml");      
        config.class使用AnnotationConfigApplicationContext(CriownConfig.class)        
_**常见于springboot 可见springboot笔记**_