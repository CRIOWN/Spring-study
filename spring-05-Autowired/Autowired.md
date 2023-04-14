# Spring-06-自动装配

1. byName
```xml
 <bean id="dog" class="com.criown.pojo.Dog"/>
<bean id="cat" class="com.criown.pojo.Cat"/>
<bean id="people" class="com.criown.pojo.People" autowire="byName">
<property name="name" value="宋天玥"/>
</bean>
```
```java
public class People {
    private Cat cat;
    private Dog dog;
    private String name;
    public void setDog(Dog dog) {
        this.dog = dog;
    }
    public void setName(String name) {
        this.name = name;
    }
}
```
根据id自动装配 区分大小写
会自动在容器上下文中查找和自己对象set方法值对应的beanid（getdog()/getcat()）     
_**需要设置set方法**_

2. byType     
会自动在容器上下文中查找和自己对象属性类型值相同的beanid（class）
```xml
    <bean class="com.criown.pojo.Dog"/>
    <bean class="com.criown.pojo.Cat"/>
    <bean id="people" class="com.criown.pojo.People" autowire="byType">
        <property name="name" value="宋天玥"/>
    </bean>
```
byType与id无关,不需要id也能实现

3. 注解自动装配
```java
public class People {
    @Autowired//自动注入
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;}
```
在要自动装入的属性或者set方法添加注解 @Autowired 
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
    <bean id="dog" class="com.criown.pojo.Dog"/>
    <bean id="cat" class="com.criown.pojo.Cat"/>
    <bean id="people" class="com.criown.pojo.People">
    </bean>
</beans>
```
_**要求1：@Autowired默认使用   byType 可用@Qualifierz指明id**_      
_**2:beans.xml中要写入_**     
```xml<context:annotation-config></context:annotation-config>```        
_**3:不需要set方法**_

@Nullable 当字段标记了这个注解 则这个字段可以为null
@Autowired(required = false) 则对象可以为空 否则不允许

4. 