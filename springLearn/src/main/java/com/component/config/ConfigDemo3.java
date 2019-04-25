package com.component.config;

import com.component.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *
 * @Scope:
 *  指定bean的作用域
 *  作用域类型：
 *  prototype：多实例：ioc容器启动并不会去调用方法创建对象，每次getBean获取时才创建
 *  singleton：单实例（默认）：ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取都是直接从容器中拿
 *  Request：每一个请求都会创建一个bean
 *  Session：同一个seesion共享一个bean
 *  Global-seesion：所有的Session共享一个Bean实例
 *
 * @Lazy：
 *  单实例bean：默认在容器启动时创建对象，开启懒加载，容器启动不创建对象，第一次使用Bean创建对象，并初始化
 */
@Configuration
public class ConfigDemo3 {
    @Scope
    @Lazy
    @Bean("scopePerson")
    public Person person(){
        System.out.println("懒加载开启后，getBean才出现这句");
        return new Person("Scope",12);
    }
}
