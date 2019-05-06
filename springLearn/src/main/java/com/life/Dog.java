package com.life;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * JR250演示
 */
@Component
public class Dog {
    public Dog(){
        System.out.println("Dog...constructor");
    }

    /**
     * 对象创建并赋值后调用
     */
    @PostConstruct
    public void init(){
        System.out.println("Dog...@PostConstruct");
    }

    /**
     * 容器移除对象之前
     */
    @PreDestroy
    public void destory(){
        System.out.println("Dog...@PreDestroy");
    }
}
