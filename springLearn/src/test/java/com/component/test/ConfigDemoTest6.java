package com.component.test;

import com.component.config.ConfigDemo5;
import com.component.config.ConfigDemo6;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试@Import的使用
 */
public class ConfigDemoTest6 {
    //通过AnnotationConfigApplicationContext来加载基于java类的配置
    private static AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(ConfigDemo6.class);
    @Test
    public void test1(){
        //获取容器中注册好的bean的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            System.out.println(beanName);
        }
    }
}
