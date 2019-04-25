package com.component.test;

import com.component.config.ConfigDemo2;
import com.component.config.ConfigDemo3;
import com.component.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试@Scope和@Lazy
 */
public class ConfigDemoTest3 {
    //通过AnnotationConfigApplicationContext来加载基于java类的配置
    private static AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(ConfigDemo3.class);

    /**
     * 测试单例作用域
     */
    @Test
    public void test1(){
        //获取bean
        Person scopePerson = (Person)applicationContext.getBean("scopePerson");
        System.out.println(scopePerson.toString());
    }

    /**
     * 测试多实例作用域
     */
    @Test
    public void test2(){
        //获取bean
        Person scopePerson = (Person)applicationContext.getBean("scopePerson");
        Person scopePerson2 = (Person)applicationContext.getBean("scopePerson");
        //多实例下，两个对象是不同的
        System.out.println(scopePerson == scopePerson2);
    }

    /**
     * 演示单例下的懒加载
     * 开启懒加载，注释getBean。不会出现标识语句
     */
    @Test
    public void test3(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        applicationContext.getBean("scopePerson");
    }
}
