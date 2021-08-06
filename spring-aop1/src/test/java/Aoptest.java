import com.liobio.impl.MyMathCalculator;
import com.liobio.inter.Calculator;
import com.liobio.proxy.CalculatorProxy;

import java.util.Arrays;

public class Aoptest {

    public static void main(String[] args) {
        Calculator calculator = new MyMathCalculator();
        System.out.println("====下为正常输出====");
        System.out.println(calculator.add(1, 2));
        System.out.println("====动态代理====");
        Calculator proxy = CalculatorProxy.getProxy(calculator);

        //代理对象和被代理对象唯一能产生的关联就是实现了同一个接口
        System.out.println(proxy.getClass());
        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
        proxy.add(1,2);

        //动态代理的问题：
        //1、代码复杂
        //2、jdk默认的动态代理，如果目标对象没有实现任何接口，是无法为其创建代理对象的

        //Spring动态代理—>Spring实现AOP功能；底层就是动态代理
        //1、可以利用Spring一句代码都不写的去创建动态代理；实现简单
        //2、没有强制要求必须实现接口


    }
}
