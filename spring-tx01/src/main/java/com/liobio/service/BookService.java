package com.liobio.service;

import com.liobio.bean.Book;
import com.liobio.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 标识一个受Spring IOC容器管理的业务逻辑Service层组件；
 * 业务逻辑层组件：@Service
 */
@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    /**
     *
     * @description
     *     Propagation propagation() default Propagation.REQUIRED;
     *      事务的传播行为
     *     Isolation isolation() default Isolation.DEFAULT;
     *      事务的隔离级别
     *     int timeout() default -1;
     *      事务超出指定执行时长后自动终止并且回滚
     *     boolean readOnly() default false;
     *      设置事务为只读事务
     *          进行事务优化
     *          readonly=TRUE 用于查询数据库事务 可以加快查询速度；不用管事务那一堆操作
     *     Class[] rollbackFor() default {};
     *      哪些异常事务需要回滚
     *     String[] rollbackForClassName()
     *      哪些异常事务需要回滚 根据string全类名
     *     Class noRollbackFor()
     *      哪些事务可以不回滚
     *     String[] noRollbackForClassName()
     *      哪些事务可以不回滚 根据string全类名
     */
    @Transactional(rollbackFor ={FileNotFoundException.class} )
    public void checkout(String username,String isbn) throws FileNotFoundException {
        /**
         * @title BookService.java
         * @author LIOBIO
         * @param: username
         * @param: isbn
         * @updateTime 2021/8/2 22:05
         * @description
         *买书后结账
         */

        bookDao.subStock(isbn);
        int price=bookDao.get_Book_Price(isbn);
        bookDao.sub_user_Balance(username,price);
        System.out.println("结账完成");
        //int a=1/0;
        // 设置一个运行异常 spring默认执行回滚 可以通过注解设置不回滚
        //new FileInputStream("D//haha.a");
        // 设置一个编译异常 spring不会对其回滚 需要通过注解设置其回滚
    }

}
