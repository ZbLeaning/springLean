package com.component.config;

import com.component.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 给容器中注册组件
 * @Configuration:
 *  告诉spring这是一个配置文件
 * @Bean:
 * 方法级别上的注解，主要用在@Configuration注解的类里，也可以用在@Component注解的类里.表示创建一个Bean
 * value -- bean别名和name是相互依赖关联的，value,name如果都使用的话值必须要一致
 * name -- bean名称，如果不写会默认为注解的方法名称
 * autowire -- 自定装配默认是不开启的，建议尽量不要开启，因为自动装配不能装配基本数据类型、字符串、数组等，这是自动装配设计的局限性，以及自动装配不如显示依赖注入精确
 * initMethod -- bean的初始化之前的执行方法，该参数一般不怎么用，因为可以完全可以在代码中实现
 * destroyMethod -- bean销毁执行的方法
 *
 */
@Configuration
public class ConfigDemo1 {
    /**
     * 给容器注册一个Bean。类型是返回值类型
     * 此种方式默认将方法名作为bean的id
     * @return
     */
    @Bean
    public Person person(){
        return new Person("demo1",18);
    }

    /**
     * 给容器注册一个Bean。类型是返回值类型
     * 此种方式bean的id由@Bean注释中定义
     * @return
     */
    @Bean("person1")
    public Person getPerson(){
        return new Person("demo2",18);
    }
}
