package com.criown.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
