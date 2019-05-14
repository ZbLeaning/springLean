package com.aop;

/**
 * 业务方法
 */
public class MainCaculator {
    public int div(int i,int j){
        System.out.println("进入业务方法");
        return i/j;
    }
}
