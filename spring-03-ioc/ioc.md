# Spring-03：对象构造
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--Spring创建对象 称之为beans
bean = 对象 == new Hello（）
id为对象名      Hello hello=new Hello()
class为对象类型  Hello类
property为对象内属性 Hello.str="Spring"
ref 引用容器中创建好的对象
-->
<bean id="user" class="com.criown.pojo.User">
<constructor-arg index="0" value="狂神"/>
</bean>
</beans>

```
上述用于无参构造
当要使用有参构造时修改\<beans>\
1. index参数下标赋值
```xml
<bean id="user" class="com.criown.pojo.User">
<constructor-arg index="0" value="狂神"/>
</bean>
```
2. 通过参数类型赋值
```xml
<bean id="user" class="com.criown.pojo.User">
    <!--当遇到参数类型重复时无法使用-->
<constructor-arg type="java.lang.String"  value="宋天玥"/>
</bean>
```
3. 通过参数名命名赋值
```xml
<bean id="user" class="com.criown.pojo.User">
<constructor-arg name="name" value="sty"/>
</bean>
```

_**在获取spring上下文时，容器内所有对象都会被初始化(构造)**_

# Spring-03: 配置说明
1. 别名-alias
```xml
<alias name="user" alias="useralias"/>
```
```xml
<bean id="userT" class="com.criown.pojo.UserT" 
      name="userT2,t2,t3"/>
<!--name中可设置多个别名，用,分割-->
```
两种方式 别名和本名都能够成功运行
2. 引入-import
```xml applicationContext
    <import resource="beans.xml"/>
    <import resource="beans2.xml"/>
```
可以将多个beans.xml汇总为一个总的xml 使用时调用总xml

Spring-