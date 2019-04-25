package com.component.config;

import com.component.importConfig.MyImportBeanDefinitionRegistrar;
import com.component.importConfig.MyImportSelector;
import com.component.pojo.Red;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 *
 * @Import 快速给容器中导入组件
 *   @Import(要导入到容器中的组件)：容器会自动注册这个组件，id默认是全类名
 *   ImportSelector:返回需要导入的组件的全类名数组
 *   ImportBeanDefinitionRegistrar:手动注册bean到容器中
 * 4、使用Spring提供的FactoryBean（工厂Bean）
 *  1、默认获取到的是工厂bean调研getObject创建的对象
 *     2、获取工厂bean本身，需要给id前加一个&
 */
@Import({Red.class,MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class ConfigDemo5 {

}
