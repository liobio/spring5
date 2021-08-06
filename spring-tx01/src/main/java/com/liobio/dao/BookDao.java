package com.liobio.dao;

import com.liobio.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * ②持久化层组件：@Respository
 * 标识一个受Spring IOC容器管理的持久化dao层组件
 */
@Repository
public class BookDao  {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void sub_user_Balance(String userName,int price){
        String sql="update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,userName);
    }

    public int get_Book_Price(String isbn){
        String sql="select price from book where isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);

    }

    public void subStock(String isbn){
        String sql="update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql,isbn);

    }


}
