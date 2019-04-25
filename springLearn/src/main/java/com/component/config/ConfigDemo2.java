package com.component.config;

import com.component.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ComponentScan：
 *  自动扫描，只要标注了@Controller @Service @Repository @Componet都会被注册到容器中
 *  该注解可以设置扫描规则，其有以下几种扫描规则：
 *      1、excludeFilters = Filter[] 指定排除规则，扫描时排除指定组件
 *      2、includeFilters = Filter[] 指定包含规则，扫描时包含指定组件
 *      3、useDefaultFilters 控制默认的排除规则，false关闭才能使用指定规则
 *  定义扫描规则@ComponentScan.Filter(type = FilterType)
 *      FilterType类型： FilterType.ANNOTATION 按照注解
 *                      FilterType.ASSIGNABLE_TYPE 按照类型 classes={BookService.class}
 *                      FilterType.ASPECTJ 按照ASPECTJ表达式 不常用
 *                      FilterType.REGEX 按照正则
 *                      FilterType.CUSTOM 自定义规则
 */
//@ComponentScan("com.component.scanbean") 扫描该包下带有指定注解的组件并注册到容器
//@ComponentScan(value = "com.component.scanbean",
//        includeFilters ={
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})}
//        ,useDefaultFilters = false)//根据注解，只加载类型是Controller注解的容器
@ComponentScan(value = "com.component.scanbean",includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {ConfigDemo2Filter.class})
},useDefaultFilters = false)//使用自定义的规则来扫描
@Configuration
public class ConfigDemo2 {
}
