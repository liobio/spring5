package com.liobio.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName LogUtils.java
 * @createTime 2021/07/31/13:59:00
 * @Description
 */
public class LogUtils {

    public static void logStart(Method method,Object... args){
        System.out.println("【"+ method.getName() +"】方法执行了，参数为【"+ Arrays.asList(args) +"】");
    }
    public static void logReturn(Method method,Object result){
        System.out.println("【"+ method.getName() +"】方法执行完成，他的结果为是："+result);
    }
    public static void logException(Method method,Exception e){
        System.out.println("【"+ method.getName() +"】方法出现了异常，异常为： "+ e.getCause());
    }
    public static void logEnd(Method method){
        System.out.println("【"+ method.getName() +"】方法执行最终完成");
    }
}
