# Spring-07-注解

@Autowired 自动装配byType
@Nullable 属性·允许为空
@Resource 自动装配（ByName）

@_**Component**_ 组件 放在类上 说明这个个类被spring（beans）管理
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        ">
    <!--开启注解支持-->
    <context:annotation-config></context:annotation-config>
    <!--包扫描 报销注解将会生效-->
    <context:component-scan base-package="com.criown.pojo"/>
</beans>
```
_**两段\<context>实现功能**_
 
```java
package com.criown.pojo;
import org.springframework.stereotype.Component;
@Component("user")
public class User {
    public String name = "加载";
}
``` 
结果为 加载
```java
@Component("user")
public class User {
   // @Value("可通过value注解赋值")
    public String name ;
}
```
结果为 null（空值）
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("user")
public class User {
    @Value("可通过@value注解赋值")
    public String name ;
}
```
结果为 可通过@value注解赋值

## 第二类注解：

pojo        @Component   eg: User       
dao         @Repository  eg：UserDao     
service     @Service     eg：UserService         
controller  @Controller  eg：UserController      
上述注解功能相同 用于将某个类注入到Spring中装配