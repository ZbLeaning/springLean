package com.imooc.test;

import com.imooc.bean.Person;
import com.imooc.config.MainConfig;
import com.imooc.config.MainConfig2;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest {

    AnnotationConfigApplicationContext  applicationContext =
            new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    @SuppressWarnings("resource")
    public void test01(){
        AnnotationConfigApplicationContext  applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        //得到容器中初始化组件
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
    }
    @Test
    public void test02(){
        AnnotationConfigApplicationContext  applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        //得到容器中初始化组件
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
        //默认单实例
        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1 == person2);
    }
    @Test
    public void test03(){
        AnnotationConfigApplicationContext  applicationContext =
                new AnnotationConfigApplicationContext(MainConfig2.class);
        //获取当前运行环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //获取操作系统名字
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType){
            System.out.println(name);
        }
    }
    @Test
    public void importTest(){
        printBeans(applicationContext);

    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
    }
}
