package com.liobio.impl;

import org.springframework.stereotype.Service;

/**
 * @author LIOBIO
 */
@Service
public class MyMathCalculator  {
//    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("add内部方法执行了");
        return result;
    }

//    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("sub内部方法执行了");
        return result;
    }

//    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("mul内部方法执行了");
        return result;
    }

//    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("div内部方法执行了");
        return result;
    }
}
