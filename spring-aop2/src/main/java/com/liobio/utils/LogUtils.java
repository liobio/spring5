package com.liobio.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName LogUtils.java
 * @createTime 2021/07/31/13:59:00
 * @Description 如何将这个类(切面类)中的这些方法(通知方法)动态的在目标方法运行的各个位置切入
 * @Before：在目标方法运行之前 前置通知
 * @after：在目标方法运行结束之后 后置通知
 * @AfterReturning：在目标方法正常放回之后 返回通知
 * @AfterThrowing：在目标方法抛异常之后 异常通知
 * @Around：环绕 环绕通知
 */
@Aspect
@Component
@Order(0)
public class LogUtils {

    //在AspectJ切面中，可以通过@Pointcut注解将一个切入点声明成简单的方法。切入点的方法体通常是空的，因为将切入点定义与应用程序逻辑混在一起是不合理的
    //在编写AspectJ切面时，可以直接在通知注解中书写切入点表达式。但同一个切点表达式可能会在多个通知中重复出现
    //1、随便声明一个没有实现的返回void的空方法
    //2、给方法上标注@Pointcut注解
    //3、在需要用到这个内容的注解execution属性内写入这个空方法的方法名
    @Pointcut("execution(public int com.liobio.impl.MyMathCalculator.*(int ,int ))")
    public void OniMyPoint(){
    }

    //execution(访问权限 方法返回值 方法签名)
    //想在执行目标方法之前
    @Before("OniMyPoint()")
    public static void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("【LogUtils】=====【"+name+"】方法开始执行了，参数为【"+ Arrays.asList(args) +"】");
    }

    //想在目标方法正执行完毕之后
    //指定的异常、结果返回值一定要写大
    //Spring对通知方法的要求不严格：修改返回值和去掉静态static都照样运行
    //但唯一有要求的是方法的参数列表一定不能乱写
    //      原因：通知方法是Spring利用反射调用的，每次调用方法都需要确定这个方法的参数表的值；
    //      参数表上的每一个参数，Spring都得知道是什么
    @AfterReturning(value = "OniMyPoint()",returning = "result")
    public static void logReturn(JoinPoint joinPoint,Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【LogUtils】=====【"+ name +"】方法执行完成，他的结果为是："+result);
    }

    //想在目标方法出现异常时执行
    //指定的异常、结果返回值一定要写大
    @AfterThrowing(value = "OniMyPoint()",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【LogUtils】=====【"+ name +"】方法出现了异常，异常为："+ e);
    }

    //想在目标方法结束时执行
    @After("OniMyPoint()")
    public static void logEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("【LogUtils】=====【" + name + "】方法执行最终完成");
    }


    /***
     * @Around环绕：是Spring中强大的通知
     * try{
     *      //前置通知
     *      method.invoke(obj,args);
     *      //返回通知
     * }catch(e){
     *      //异常通知
     * }finally{
     *     //后置通知
     * }
     *
     * 四合一通知就是环绕通知
     *  环绕通知中有一个参数
     *  环绕的在一个切面内的优先级 永远最高
     */
    @Around("OniMyPoint()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        String name = pjp.getSignature().getName();
        Object proceed = null;
        try {
            //@Before
            System.out.println("【环绕前置通知】=====【"+name+ "方法开始】");
            //利用反射调用目标方法，就是method.invoke(obj,args);
            proceed = pjp.proceed(args);
            //@AfterReturning
            System.out.println("【环绕返回通知】=====【"+name+ "方法返回，返回结果值为"+ proceed+"】");
        } catch (Exception e) {
            //@AfterThrowing
            System.out.println("【环绕异常通知】=====【"+name+ "方法异常，异常信息为"+ e+"】");
        } finally {
            //@After
            System.out.println("【环绕后置通知】=====【"+name+ "方法结束");
        }

        //反射调用后的返回值也一定返回出去，不返回会空指针
        return proceed;

    }
}
