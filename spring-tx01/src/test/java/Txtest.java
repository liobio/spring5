import com.liobio.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName Txtest.java
 * @createTime 2021/08/02/23:11:00
 * @Description
 */
public class Txtest {
    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext ioc=new ClassPathXmlApplicationContext("tx.xml");
        BookService bean = ioc.getBean(BookService.class);
        bean.checkout("Tom","ISBN-001");
    }
}
