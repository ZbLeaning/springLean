package com.life;

/**
 * bean的生命周期
 *  测试
 */

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class LifeTestDemo1 {

    @Test
    public void Test(){
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(LifeDemo1.class);
        System.out.println("容器创建完成");
        applicationContext.close();
        System.out.println("bean销毁完成");
    }
}
