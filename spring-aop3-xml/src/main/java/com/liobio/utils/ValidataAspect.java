package com.liobio.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName ValidataAspect.java
 * @createTime 2021/08/01/17:57:00
 * @Description
 */
public class ValidataAspect {

    public static void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("【ValidataAspect】=====【"+name+"】方法开始执行了，参数为【"+ Arrays.asList(args) +"】");
    }

    public static void logReturn(JoinPoint joinPoint,Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【ValidataAspect】=====【"+ name +"】方法执行完成，他的结果为是："+result);
    }

    public static void logException(JoinPoint joinPoint,Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【ValidataAspect】=====【"+ name +"】方法出现了异常，异常为："+ e);
    }

    public static void logEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【ValidataAspect】=====【" + name + "】方法执行最终完成");
    }
}
