## MVC-01-Bug

```
访问出现404，排查步骤：
1.查看控制台输出，看一下是不是缺少了什么jar包。
2.如果jar包存在，显示无法输出，就在IDEA的项目发布中，添加lib依赖！
3.重启Tomcat (详见https://www.bilibili.com/video/BV1aE41167Tu?p=4&vd_source=63345c7173dd63760dc97626f9e2a256)
```

当出现乱码时在web.xml中配置过滤器 详见04 课程p13
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
并且在springmvc-servlet.xml中配置如下
```xml
<!--注解实现 处理映射器和处理适配器自动配置 并解决乱码问题-->
    <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8"/>
            </bean>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="objectMapper">
                    <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                        <property name="failOnEmptyBeans" value="false"/>
                    </bean>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>


```