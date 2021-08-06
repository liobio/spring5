package com.liobio.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName LogUtils.java
 * @createTime 2021/07/31/13:59:00
 * @Description 如何将这个类(切面类)中的这些方法(通知方法)动态的在目标方法运行的各个位置切入
 * @Before：在目标方法运行之前 前置通知
 * @after：在目标方法运行结束之后 后置通知
 * @AfterReturning：在目标方法正常放回之后 返回通知
 * @AfterThrowing：在目标方法抛异常之后 异常通知
 * @Around：环绕 环绕通知
 */

public class LogUtils {

    public void OniMyPoint(){
    }


    public static void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("【LogUtils】=====【"+name+"】方法开始执行了，参数为【"+ Arrays.asList(args) +"】");
    }

    public static void logReturn(JoinPoint joinPoint,Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【LogUtils】=====【"+ name +"】方法执行完成，他的结果为是："+result);
    }

    public static void logException(JoinPoint joinPoint,Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【LogUtils】=====【"+ name +"】方法出现了异常，异常为："+ e);
    }

    public static void logEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【LogUtils】=====【" + name + "】方法执行最终完成");
    }

    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        String name = pjp.getSignature().getName();
        Object proceed = null;
        try {
            //@Before
            System.out.println("【环绕前置通知】=====【"+name+ "方法开始】");
            //利用反射调用目标方法，就是method.invoke(obj,args);
            proceed = pjp.proceed(args);
            //@AfterReturning
            System.out.println("【环绕返回通知】=====【"+name+ "方法返回，返回结果值为"+ proceed+"】");
        } catch (Exception e) {
            //@AfterThrowing
            System.out.println("【环绕异常通知】=====【"+name+ "方法异常，异常信息为"+ e+"】");
        } finally {
            //@After
            System.out.println("【环绕后置通知】=====【"+name+ "方法结束");
        }

        //反射调用后的返回值也一定返回出去，不返回会空指针
        return proceed;

    }
}
