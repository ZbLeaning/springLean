package com.life;

/**
 * bean的生命周期
 *  bean的创建-初始化-销毁的过程
 * 容器管理bean的生命周期
 *
 * 对象创建：
 *      单实例：在容器启动时创建对象
 *      多实例：在每次获取时创建对象 调用getBean方法
 *
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 * 销毁：
 *      单实例：在容器关闭时进行销毁
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法
 * 1、在配置文件中指定初始化和销毁方法 init-method/destroy-method
 * 2、使用注解@Bean(initMethod = "init",destroyMethod = "destory")
 * 3、通过让bean实现InitalizingBean（定义初始化逻辑）、实现DisposableBean（定义销毁逻辑）
 * 4、可以使用JSR250，注解在bean的指定方法上
 *        @PostConstruct（初始化）：在bean创建完成并且属性赋值完成，来执行初始化
 *        @PreDestory(销毁)：在容器销毁bean之前通知我们进行清理工作
 * 5、BeanPostProcessor：bean的后置处理器
 *      在bean初始化前后进行一些处理
 *      postProcessBeforeInitialization：在初始化之前工作
 *      postProcessAfterInitialization：在初始化之后工作
 * 6、Spring提供以Aware结尾的接口，实现了Aware接口的bean在初始化之后，可以获取相应资源，并对资源进行操作
 *      ApplicationContextAware：实现setApplicationContext（ApplicationContext applicationContext）方法。applicationContext.getBean(“bean的id”)得到bean
 *      BeanNameAware：实现setBeanName（String arg0）方法。参数arg0就是bean的id
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.life")
@Configuration
public class LifeDemo1 {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }


}
