package com.imooc.bean;

import com.imooc.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        Person person = (Person)applicationContext.getBean("person");
//        System.out.println(person.toString());

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean.toString());

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String str:beanNamesForType){
            System.out.println(str);
        }
    }
}
