import com.liobio.service.BookService;
import com.liobio.service.UserService;
import com.liobio.servlet.BookServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

        /**
         * 实验15：通过注解分别创建Dao、Service、Controller【★】
         * ⑤组件命名规则
         *      [1]默认情况：使用组件的为简单类名首字母小写后得到的字符串作为bean的id
         *          也可以通过直接设置默认id @Respository（" name "）
         *      [2]使用组件注解的value属性指定bean的id
         * 组件的作用域—默认为单例模式
         *      可通过@Scope修改作用域模式
         *           @Scope(value = "prototype")
         *
         * 事实上Spring并没有能力识别一个组件到底是不是它所标记的类型，
         * 即使将@Respository注解用在一个表述层控制器组件上面也不会产生任何错误，
         * 所以@Respository、@Service、@Controller这几个注解仅仅是为了让开发人员自己明确当前的组件扮演的角色。
         */
        Object bookDao = ioc.getBean("bookDao");
        Object bookDao1 = ioc.getBean("bookDao");
        System.out.println(bookDao);
        System.out.println(bookDao == bookDao1);
        /**
         * 实验18：使用@Autowired注解实现根据类型实现自动装配【★】
         *     @Autowired
         *     private BookService bookService;
         *         1、先按照类型去容器找到对应的组件； bookService = ioc.getBean("BookService.class");
         *             ①匹配成功；装配 ②匹配失败；抛出异常报错
         *             ③匹配多个；
         *             按照变量名作为id继续匹配
         *
         *                     1）匹配成功；装配
         *                     2）匹配失败；抛出异常报错
         *                         失败原因：Spring会使用id在容器中匹配
         *                         【可使用@Qualifier("xxxXxx")指定一个新id匹配】
         *                             1）匹配成功；装配
         *                             2）匹配失败；抛出异常报错
         *
         *           发现AutoWired标注的自动装配的属性默认是一定装配上，任何情况下没匹配就是抛出异常报错
         *                 找到就装配，找不到就拉倒
         *                 @Autowired(required=false)：默认为true，给为匹配上的赋值为null
         *
         */
//            BookServlet bookServlet = (BookServlet) ioc.getBean("bookServlet");
//            bookServlet.doGet();
        /** 可以用@Qualifier指定id去匹配；此注解可修饰参数

       @Autowired和@Resource、@Inject的区别【★】

       @Autowired、@Resource、@Inject都可以作为注入注解
       @Autowired：最强大；Spring的注解
	            ①扩展性差，依赖Spring容器框架
       @Resource：j2ee；java的标准【jdk标准】
	            扩展性强：切换成另一个容器框架，其还会可以使用
       @Inject：在EJB环境下使用（）】
       **/

        /**
         *  实验19：测试泛型依赖注入★
         */

        BookService bookService = ioc.getBean(BookService.class);
        UserService userService = ioc.getBean(UserService.class);

        bookService.save();// BookDao。。。保存图书
        userService.save();// UserDao。。。保存用户
        System.out.println(bookService.getClass().getGenericSuperclass());
    }

}
