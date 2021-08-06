package com.liobio.proxy;

import com.liobio.inter.Calculator;
import com.liobio.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName CalculatorProxy.java
 * @createTime 2021/07/30/18:05:00
 * @Description
 */
public class CalculatorProxy {
    /**
     * @title CalculatorProxy.java
     * @author LIOBIO
     * @updateTime 2021/7/30 18:05
     * @description
     * 为传入的参数对象创建一个动态的代理对象
     * jdk默认的动态代理，如果目标对象没有实现任何接口，是无法为其创建代理对象的
     */
    public static Calculator getProxy(final Calculator calculator) {

        ClassLoader loader = calculator.getClass().getClassLoader();//被代理对象的类加载器
        Class<?>[] interfaces = calculator.getClass().getInterfaces();//查看实现了哪些接口

        InvocationHandler h = new InvocationHandler() {
            /**
             * @param proxy 代理对象，给jdk使用，任何时候都不要动这个对象
             * @param method 当前要执行的目标对象的方法
             * @param args 这方法调用时，外界传的值
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                // method.invoke 利用反射执行目标方法
                // result目标方法执行后的返回值
                Object result = null;
                try {
                    LogUtils.logStart(method,args);
                    result = method.invoke(calculator, args);
                    LogUtils.logReturn(method, result);
                } catch (Exception e) {
                   LogUtils.logException(method, e);
                }finally {
                   LogUtils.logEnd(method);
                }

                return result;
            }
        };//调用处理程序 方法执行器

        Object proxy = Proxy.newProxyInstance(loader, interfaces, h); //Proxy为目标对象创建代理对象
        return (Calculator) proxy;


    }
}




