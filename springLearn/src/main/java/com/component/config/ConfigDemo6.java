package com.component.config;

import com.component.factory.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用Spring提供的FactoryBean（工厂Bean）
 *     1、默认获取到的是工厂bean调研getObject创建的对象
 *     2、获取工厂bean本身，需要给id前加一个&
 */
@Configuration
public class ConfigDemo6 {
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
