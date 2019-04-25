package com.component.config;

import com.component.pojo.Person;
import org.springframework.context.annotation.*;

/**
 *
 *  @Conditional({Condition})：
 *      按照一定的条件进行判断，满足条件给容器中注入bean
 *      可以标注在类也可以标注在方法上
 *      在类上注解，满足条件，这个类中配置的所有bean注册才能生效
 *      当前操作系统是windows则注册Windows，不是则注册Linux
 */
//@Conditional(ConditionalWindows.class)//是windows系统才会加载该类中的bean
@Configuration
public class ConfigDemo4 {
    //是windows系统才注册该bean
    @Conditional(ConditionalWindows.class)
    @Bean("windows")
    public Person person1(){
        return new Person("windows",12);
    }
    //是linux系统才注册该bean
    @Conditional(ConditionalLinux.class)
    @Bean("linux")
    public Person person2(){
        return new Person("linux",12);
    }

}
