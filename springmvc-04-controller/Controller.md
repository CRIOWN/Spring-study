## MVC-02-controller


_**springmvc-servlet.xml是默认 不用修改**_
```xml
<?xml version="1.0" encoding="UTF8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
<!--自动扫描包 让指定报下的注解生效 由ioc容器统一管理-->
    <context:component-scan base-package="com.criown.controller"/>
<!--让springmvc不处理静态资源-->
<mvc:default-servlet-handler/>
<!--注解实现 处理映射器和处理适配器自动配置-->
    <mvc:annotation-driven/>
    <!--3： 视图解析器:DispatcherServlet给他的ModelAndView-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
        <!--前缀-->
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <!--后缀-->
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```


如下配置页面为..../t1/t2
页面资源均为WEB_INF/jsp/_**test**_.jsp 页面资源存储位置
```java
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
```
如下配置获得两个页面 ..../t2 和 ..../t3
```java
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
```

`2. restFul风格`
```java
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

```

`过滤器 `
```xml
<!--    过滤器2-->
    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encofing</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```
防止出现乱码 加在web.xml中