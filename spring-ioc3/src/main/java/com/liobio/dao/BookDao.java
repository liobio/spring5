package com.liobio.dao;

import com.liobio.bean.Book;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ②持久化层组件：@Respository
 * 标识一个受Spring IOC容器管理的持久化dao层组件
 */
@Repository
public class BookDao extends BaseDao<Book> {
    @Override
    public void save() {
        System.out.println("BookDao。。。保存图书");
    }
}
