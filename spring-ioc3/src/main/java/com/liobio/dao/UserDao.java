package com.liobio.dao;

import com.liobio.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("UserDao。。。保存用户");
    }
}
