import com.liobio.bean.Car;
import com.liobio.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Mytest {
    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("ioc1.xml");
        System.out.println("ioc启动完成====");

        /**
         * 实验10：创建带有生命周期方法的bean
         * 生命周期： bean的创建到销毁；
         *
         * ioc容器注册的bean：
         * 1、单例bean，容器启动时创建好，容器关闭就销毁
         * 2、多例bean，获取时才创建
         */
////          多例bean，获取时才创建
////          多例Bean的生命周期-->
////              获取bean时(构造器创建对象)—>初始化方法—>(容器关闭)不会调用销毁方法
//        Object book01 = ioc.getBean("book02");
//
////          单例Bean的生命周期
////              构造器—>初始化方法—>（容器关闭）销毁方法
//
//        ioc.close();
//        System.out.println("ioc关闭了====");
        /**
         * 实验11：测试bean的后置处理器
         * 后置处理器：
         *
         * （容器启动）构造器—>后置处理器before方法—>初始化方法—>后置处理器的after方法
         * 无论bean是否有初始化方法；后置处理器都会工作，默认其有，还会继续工作

         */
//        Object book01 = ioc.getBean("book02");
//        ioc启动完成====
//        书本被创建了====
//        postProcessBeforeInitialization running====
//        【book02】bean将要调用初始化方法了...这个bean对象是： Book{bookname='null', author='null'}
//        书本被初始化了====
//        postProcessAfterInitialization running====
//        【book02】bean初始化完了...这个bean对象是： Book{bookname='null', author='null'}
        /**
         * 实验12：引用外部属性文件【★】—Spring管理连接池
         * 通过Spring单例与数据库连接池连接（这里使用的阿里巴巴德鲁伊数据库连接池）
         */
//        DataSource dataSource = ioc.getBean(DataSource.class);
//        Car car = ioc.getBean(Car.class);
//        System.out.println(dataSource.getConnection());//com.mysql.cj.jdbc.ConnectionImpl@1372ed45
//        System.out.println(car.getCarname());//LIOBIO
        /**
         * 实验13：基于XML的自动装配（自动赋值）
         *         自动赋值（自动装配）：仅限于对自定义类型的属性有效；自动的为属性赋值
         */
//        Person bean = ioc.getBean(Person.class);
//        System.out.println(bean);
        /**
         * 实验14：[SpEL测试I]
         * 简介
         * Spring Expression Language，Spring表达式语言，简称SpEL。支持运行时查询并可以操作对象图。
         * 和JSP页面上的EL表达式、Struts2中用到的OGNL表达式一样，SpEL根据JavaBean风格的getXxx()、setXxx()方法定义的属性访问对象图，完全符合我们熟悉的操作习惯。
         */
//        Person bean = ioc.getBean("person02",Person.class);
//        System.out.println(bean);


    }
}
