import com.liobio.bean.Car;
import com.liobio.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Predicate;

public class MyTest {
    public static void main(String[] args) {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
        System.out.println("ioc启动完成");
        /**
         * test01通过IOC容器创建对象，并为属性赋值【★】
         * 实验1：
         */
//        Person bean = (Person) ioc.getBean("person1");
//        System.out.println(bean);
        /**
         * test02根据bean的类型从IOC容器中获取bean的实例【★】
         *
         */
//         Person bean = ioc.getBean(Person.class);
//        如果ioc容器中这个类型的bean有多个，查找就会报错
//        报错： No qualifying bean of type 'com.achang.bean.Person'
//         available: expected single matching bean but found 2: person01,person02
//        System.out.println(bean);
//
//        Person bean2 = ioc.getBean("person02", Person.class);// Person{lastName='真田幸村', age=19, gender='男', email='zhentianxincun@achang.com'}
//         System.out.println(bean2);
        /**
         * test03—通过构造器为bean的属性赋值（index,type属性介绍）
         *
         *
         * index属性：指定对应参数的索引下标，从0开始
         *
         * value属性：设置参数的值
         *
         * type属性：指定该为 什么类型的参数
         */
//        Object person03 = ioc.getBean("person03");
//        System.out.println(person03);
//
//        Object person04 = ioc.getBean("person04");
//        System.out.println(person04);
        /**
         * test04：正确的为各种属性赋值
         */
//        Person person01 = ioc.getBean("person01", Person.class);
//        Person person02 = ioc.getBean("person02", Person.class);
//        Person person03 = ioc.getBean("person03", Person.class);
//        Person person04 = ioc.getBean("person04", Person.class);
//        Person person05 = ioc.getBean("person05", Person.class);
//        Person person06 = ioc.getBean("person06", Person.class);
//        Car car=person03.getCar();
//        Object car01 = ioc.getBean("car01");
//        Map<String,Object> map1=person04.getMap();
//        Map<String, Object> map2 = person05.getMap();
//        List list= person04.getBooks();
//        Properties properties = person04.getProperties();
//
//        System.out.println(person01);//Person{lastName='null', age=null, gender='null', email='null', car=null, books=null, maps=null, properties=null}
//        System.out.println(person02.getCar());//Car{carname='大泵', color='绿色', price=3000}
//        System.out.println(car);//Car{carname='自行车', color='null', price=null}
//        System.out.println(map1);//{姓名=刘备, 编号=18, 书1=Book{bookname='三国演义', author='罗贯中'}, 书2=Book{bookname='转行成功手册', author='null'}, ={}}
//        System.out.println(list);//[Book{bookname='三国演义', author='罗贯中'}, Book{bookname='西游记', author='null'}]
//        System.out.println(properties);//{password=00000, username=root}
//        System.out.println(map2);//{key01=张三, key02=18, key03=Book{bookname='三国演义', author='罗贯中'}, key04=Car{carname='baoma', color='null', price=null}}
//        System.out.println(map2.getClass());//class java.util.LinkedHashMap util:map 默认创建的是LinkedHashMap
//        System.out.println(person06.getCar()==car01);//ture
//        System.out.println(car01);//Car{carname='大泵', color='绿色', price=9999} 且上面的car01也会改
        /**
         * test06：通过继承实现bean配置信息的重用
         * parent属性：指定当前bean的配置信息继承于哪个，只是配置信息
         */
//        Person person07 = ioc.getBean("person07", Person.class);
//        Person person08 = ioc.getBean("person08", Person.class);
//        System.out.println(person07);//Person{lastName='周瑜', age=18, gender='男', email='zhouyu@achang.com', car=null, books=null, map=null, properties=null}
//        System.out.println(person08);//Person{lastName='继承person07', age=18, gender='男', email='zhouyu@achang.com', car=null, books=null, map=null, properties=null}
        /**
         * test07：通过abstract属性创建一个模板bean
         * abstract属性：这个bean是抽象的，不能获取实例，只能被其他bean继承
         */
//        Person person09 = ioc.getBean("person09", Person.class);
//        Error creating bean with name 'person09': Bean definition is abstract
//        不能获取实例，只能被其他bean继承
//      Person person10 = ioc.getBean("person10", Person.class);
//       System.out.println(person10);
        /**
         * test08：测试bean的作用域，分别创建单实例和多实例的bean【★】
         *     bean的作用域：bean是否单实例；默认，单实例
         *
         *     scope属性：设置单例模式、多例模式
         *
         *     singleton：单实例模式；默认
         *     1）在容器启动完成之前，就已经创建好对象，并保存在容器中
         *     2）任何时候获取都是获取之前创建好的那个对象
         *
         *     prototype：多实例模式；
         *     1）在容器启动默认不会去创建多实例bean
         *     2）获取时，才创建bean
         *     3）每次获取都会创建一个新的实例，每次都会调用构造器创建
         */
//        Object bean1 = ioc.getBean("book");
//        Object bean2 = ioc.getBean("book");
//        System.out.println(bean1==bean2);//true
//        //任何时候获取都是获取之前创建好的那个对象
//
//        Object bean3 = ioc.getBean("car");
//        Object bean4 = ioc.getBean("car");
//        System.out.println(bean3==bean4);//false
//        //每次获取都会创建一个新的实例，每次都会调用构造器创建
        /**
         * test09：配置通过静态工厂方法创建的bean、实例工厂方法创建的bean、FactoryBean【★】
         * 工厂模式：工厂帮我们创建对象，有一个专门帮我们创建对象的类，这个类就是工厂
         * 静态工厂：工厂本身不用创建对象；通过静态方法调用，
         *
         *
         * 静态工厂：工厂本身不用创建对象；通过静态方法调用，
         * 对象 = 工厂类.工厂方法名();
         *
         * 实例工厂：工厂本身需要被创建；*
         * 工程类 工厂对象 = new 工程类();
         * 工厂对象.getAirPlane("刘备");
         *
         *
         */
//        Object bean = ioc.getBean("airPlane01");
//        //不需要创建工厂本身，容器创建完就已经创建完毕工厂本身。
//        System.out.println(bean);
//        //Airplane{fdj='海星', yc='145.23m', personNum=300, jzName='刘烨', fjsName='zyc'}
//
//        Object bean1 = ioc.getBean("airPlane02");
//        System.out.println(bean1);
//        //Airplane{fdj='海星', yc='145.23m', personNum=300, jzName='李磊', fjsName='zyc'}
//
//        //FactoryBean【★】
//        Object bean2 = ioc.getBean("factoryBean");
//        System.out.println(bean2);




    }
}
