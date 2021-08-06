package com.liobio.factory;

import com.liobio.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * 实现了FactoryBean接口的类都是Spring可以认识的工厂类；
 *  Spring会自动调用工厂方法创建实例
 */
public class MyFactoryBeanImpl implements FactoryBean<Book> {

    //getObject()：工厂方法，Spring自动调用
    //返回创建的对象
    @Override
    public Book getObject() throws Exception {
        Book book =new Book();
        book.setBookname(UUID.randomUUID().toString());
        return book;
    }
    //返回创建类型类型，Spring自动调用确认创建对象是什么类型
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    //isSingleton：是单例吗？
    //false：不是单例
    //true：是单例

    //无论是否是单例 ioc在被启动的时候都不会创建对象 在被调用的时候才会创建调用对象
    @Override
    public boolean isSingleton() {
        return false;
    }
}
