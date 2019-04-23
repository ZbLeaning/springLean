package com.imooc.config;

import com.imooc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 配置类==配置文件
 */
@Configuration  //告诉spring这是一个配置文件
//@ComponentScan(value = "com.imooc",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes =
//                {Controller.class, Service.class})
//})
@ComponentScan(value = "com.imooc",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes =
//                {Controller.class, Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
//@ComponentScan value：指定要扫描的包
//excludeFilters = Filter[] 指定排除规则，扫描时排除指定组件
//includeFilters = Filter[] 指定包含规则，扫描时包含指定组件
//useDefaultFilters 控制默认得排除规则
//FilterType.ANNOTATION 按照注解
//FilterType.ASSIGNABLE_TYPE 按照类型 classes={BookService.class}
//FilterType.ASPECTJ 按照ASPECTJ表达式 不常用
//FilterType.REGEX 按照正则
//FilterType.CUSTOM 自定义规则
public class MainConfig {
    //给容器注册一个Bean，类型为返回值类型，id默认方法名为id
//    @Bean
//    public Person person(){
//        return new Person("lisi",20);
//    }
    @Bean("person")
    public Person person01(){
        return new Person("lisi",20);
    }
}
