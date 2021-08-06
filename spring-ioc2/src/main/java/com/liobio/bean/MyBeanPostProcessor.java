package com.liobio.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     *     Object bean参数为： 将要初始化的bean
     *     String beanName 参数为： 将要初始化bean的名字
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization running====");
        System.out.println("【"+beanName+"】bean将要调用初始化方法了...这个bean对象是： "+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization running====");
        System.out.println("【"+beanName+"】bean初始化完了...这个bean对象是： "+bean);
        //初始化后返回的bean，返回的是什么 容器中保存的就是什么
        return bean;
    }
}
