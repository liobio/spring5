import com.liobio.impl.MyMathCalculator;
import com.liobio.inter.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Aoptest {

    public static void main(String[] args) {
        ApplicationContext aop = new ClassPathXmlApplicationContext("aop.xml");
        /**
         * test01 有接口类
         */
        //有接口类
        //public class MyMathCalculator implements Calculator
        //1、从ioc容器中拿到目标对象
        //注意：如果想要用类型获取，一定要用他的接口类型，不要用他的本类
//        Calculator bean = aop.getBean(Calculator.class);//com.liobio.impl.MyMathCalculator@3c41ed1d
//        bean.add(1,1);
//        System.out.println(bean);
//        System.out.println(bean.getClass());
        //细节一:com.liobio.impl.MyMathCalculator@3c41ed1d
        //      class com.sun.proxy.$Proxy16
        //      AOP的底层就是动态代理，容器中保存的组件是他的代理对象; $Proxy16当然不是本类的类型

        /**
         * test02 无接口类
         */
        //无接口类
        //public class MyMathCalculator
        //没有接口就是本类类型
        //cglib帮我们创建好的代理对象
//        MyMathCalculator myMathCalculator = aop.getBean(MyMathCalculator.class);
//        System.out.println(myMathCalculator);//com.liobio.impl.MyMathCalculator@6f27a732
//        System.out.println(myMathCalculator.getClass());//class com.liobio.impl.MyMathCalculator$$EnhancerBySpringCGLIB$$1b050541

        /**
         * test03
         */
        MyMathCalculator myMathCalculator = aop.getBean(MyMathCalculator.class);
        myMathCalculator.add(1,1);
        System.out.println("====");
        myMathCalculator.div(1,0);


    }
}
