package com.component.test;

import com.component.config.ConfigDemo1;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试@Configuration+@Bean 注解的使用
 */
public class ConfigDemoTest1 {
    //通过AnnotationConfigApplicationContext来加载基于java类的配置
    private static AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(ConfigDemo1.class);
    @Test
    public void test1(){
        //获取容器中注册好的bean的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            System.out.println(beanName);
        }
    }
}
