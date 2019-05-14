package com.aop;

import com.component.config.ConfigDemo1;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AopDemoTest1 {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(MainConfigAOP.class);
        MainCaculator mainCaculator = applicationContext.getBean(MainCaculator.class);
        mainCaculator.div(1,1);
        applicationContext.close();
    }
}
