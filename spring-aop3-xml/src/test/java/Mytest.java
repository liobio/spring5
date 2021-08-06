import com.liobio.impl.MyMathCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.krb5.internal.APOptions;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName Mytest.java
 * @createTime 2021/08/01/19:03:00
 * @Description
 */
public class Mytest {
    public static void main(String[] args) {

        ApplicationContext aop = new ClassPathXmlApplicationContext("aop.xml");
        MyMathCalculator myMathCalculator = aop.getBean(MyMathCalculator.class);
        myMathCalculator.add(1,1);
        System.out.println("====");
        myMathCalculator.div(1,0);
    }
}
