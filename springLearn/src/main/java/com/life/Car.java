package com.life;

/**
 * 注解实现bean生命周期管理
 */
public class Car {
    public Car() {
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car init...");
    }

    public void destory(){
        System.out.println("car destory...");
    }
}
