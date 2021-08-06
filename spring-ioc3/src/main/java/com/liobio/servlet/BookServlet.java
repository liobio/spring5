package com.liobio.servlet;

import com.liobio.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * 表述层控制器组件：@Controller
 * 标识一个受Spring IOC容器管理的表述Servlet层控制器组件；
 */
@Controller
public class BookServlet {

    @Autowired
    private BookService bookService;
     public void doGet(){
         bookService.save();
     }
}
