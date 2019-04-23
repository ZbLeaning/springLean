package com.imooc.config;

import com.imooc.bean.Blue;
import com.imooc.bean.ColorFactoryBean;
import com.imooc.bean.Person;
import com.imooc.bean.Red;
import com.imooc.condition.LinuxCondition;
import com.imooc.condition.MyImportBeanDefinitionRegistrar;
import com.imooc.condition.MyImportSelector;
import com.imooc.condition.WindowsCondtion;
import javafx.scene.paint.Color;
import org.springframework.context.annotation.*;



@Configuration
@Import({Blue.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    /**
     * @Scope指定bean的作用域
     * prototype：多实例：ioc容器启动并不会去调用方法创建对象，每次getBean获取时才创建
     * singleton：单实例（默认）：ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取都是直接从容器中拿
     *
     * 懒加载：
     *      单实例bean：默认在容器启动时创建对象，开启懒加载，容器启动不创建对象，第一次使用Bean创建对象，并初始化
     * @return
     */
    @Scope
    @Lazy
    @Bean("person")
    public Person person(){
        return new Person("张三",25);
    }
    /**
     * @Conditional({Condition})：按照一定的条件进行判断，满足条件给容器中注入bean
     * 可以标注在类也可以标注在方法上
     * 在类上注解，满足条件，这个类中配置的所有bean注册才能生效
     * 当前操作系统是windows则注册Windows，不是则注册Linux
     */
    @Bean("windows")
    @Conditional({WindowsCondtion.class})
    public Person person1(){
        return new Person("windows",60);
    }

    @Bean("linux")
    @Conditional({LinuxCondition.class})
    public Person person2(){
        return new Person("linux",70);
    }
    /**
     * 给容器中注册组件的方式：
     * 1、包扫描+组件标注注解 自己写的类
     * 2、使用@Bean 导入的三方包组件
     * 3、@Import 快速给容器中导入组件
     *   3.1、@Import(要导入到容器中的组件)：容器会自动注册这个组件，id默认是全类名
     *   3.2、ImportSelector:返回需要导入的组件的全类名数组
     *   3.3、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4、使用Spring提供的FactoryBean（工厂Bean）
     *  1、默认获取到的是工厂bean调研getObject创建的对象
     *     2、获取工厂bean本身，需要给id前加一个&
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
