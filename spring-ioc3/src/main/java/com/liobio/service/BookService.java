package com.liobio.service;

import com.liobio.bean.Book;
import com.liobio.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 标识一个受Spring IOC容器管理的业务逻辑Service层组件；
 * 业务逻辑层组件：@Service
 */
@Service
public class BookService extends BaseService<Book>{

}
