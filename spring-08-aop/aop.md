# Spring-09-AOP


 ##1. 使用spring的API接口

### 配置部分：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd">
    <bean id="userService" class="com.criown.service.UserServiceImpl"></bean>
    <bean id="log" class="com.criown.log.Log"/>
    <bean id="afterlog" class="com.criown.log.AfterLog"/>
    <!--需要导入aop约束-->

    <!--使用原生API接口-->
    <aop:config>
        <!--切入点id  expression= 表达式 -->
        <aop:pointcut id="pointcut" expression="execution(* com.criown.service.UserServiceImpl.*(..))"/>

        <!--执行环绕增加-->
        <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
        <aop:advisor advice-ref="afterlog" pointcut-ref="pointcut"/>
    </aop:config>
</beans>
```
通过以下代码段增加切入点  
```xml
    <aop:pointcut id="pointcut" expression="execution(* com.criown.service.UserServiceImpl.*(..))"/>
```
通过以下代码增加要切入的对象 两个参数分别对应要切入的对象id和切入点的id
```xml
 <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
```
两个切入对象在log中分别继承两个不同的接口对应方法前日志和方法后日志

### 代码部分：
```java Log
public class Log implements MethodBeforeAdvice {
    //method 要执行的目标对象的方法
    // object 参数
    //o target 目标对象
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+"类的"+method.getName()+"方法被执行了");
    }
}
```

```java test
public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理代理的是接口！！ 不是实现类
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
```


##2. 自定义API实现
自定义类如下
```java
public class DiyPointCut {
    public void before()
    {
        System.out.println("========BEFORE============");
    }
    public  void after(){
        System.out.println("=========AFTER=============");
    }
}
```
```xml
<bean id="diy" class="com.criown.diy.DiyPointCut"/>
    <aop:config>
<!--        aspect 被模块化的特殊对象（一个类）引用diy-->
        <aop:aspect ref="diy">
            <!--execution()是切点函数 可分为四个部分 * com.criown.service.UserServiceImpl.*(..)
              * 第一个为返回值类型 *表示为任意类型
               com.criown.service. 第二个为包名 表示范围是当前包下
               UserServiceImpl. 第三个为类 *表示所有的类
               *（..） 第四个为方法名 *表示所有方法 后面括号内为方法的参数 ..表示任意参数-->
            <aop:pointcut id="point" expression="execution(* com.criown.service.UserServiceImpl.*(..))"/>
            <aop:before method="before" pointcut-ref="point"/>
            <aop:after method="after" pointcut-ref="point"/>
        </aop:aspect> 
    </aop:config>
```

##3. 注解实现

```java
//使用方式3 注解
//标注该类为一个切面
@Aspect
public class AnnotationPointCut {
    //注解方式配置 导入包为xxxx.annotation.xxxx 注解包
    @Before("execution(* com.criown.service.UserServiceImpl.*(..))")
    public void before()
    {
        System.out.println("========执行前============");
    }

    @After("execution(* com.criown.service.UserServiceImpl.*(..))")
    public  void after(){
        System.out.println("=========执行后=============");
    }

    //环绕 --- 可以给定一个参数 代表我们要获取处理的切入点
    @Around("execution(* com.criown.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("loading。。。。");
        Signature signature = jp.getSignature();
        System.out.println("Signature"+signature);
        Object proceed = jp.proceed();
        System.out.println("Ending。。。。");

    }
}
```
结果如下 先执行环绕再执行before/after
```
loading。。。。
Signaturevoid com.criown.service.UserService.select()
========执行前============
查询一个用户
Ending。。。。
=========执行后=============
```
