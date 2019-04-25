package com.component.test;

import com.component.config.ConfigDemo1;
import com.component.config.ConfigDemo2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试@ComponentScan-自动扫描组件&指定扫描规则
 */
public class ConfigDemoTest2 {
    //通过AnnotationConfigApplicationContext来加载基于java类的配置
    private static AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(ConfigDemo2.class);

    @Test
    public void test1(){
        //获取容器中注册好的bean的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames){
            System.out.println(beanName);
        }
    }
}
