package com.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *  1、导入aop模块：spring-aspects
 *  2、定义一个业务逻辑类MainCaculator
 *  3、实现功能：在业务逻辑运行时，将日志进行打印（方法之前，方法结束，异常都会进行打印）
 *  4、定义一个日志切面类LogAspects，切面类的方法需要动态感知方法运行到哪儿了，然后执行
 *      通知方法：
 *      前置（@Before）：logStart：在目标方法运行之前运行
 *      后置(@After)：logStop：在目标方法运行结束之后运行，无论方法正常还是异常结束都调用
 *      返回(@AfterReturing)：logReturn：在目标方法正常返回之后执行
 *      异常(@AfterThrowing)：logException：在目标方法出现异常之后执行
 *      环绕(@Around)：动态代理，手动推进目标方法运行（joinPoint.procced()）
 *  5、给切面类的目标方法标注何时何地运行
 *  6、将切面类和目标方法所在类都加入到容器中
 *  7、配置类添加注解@EnableAspectJAutoProxy：启用基于注解的aop模式
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {
    //将业务类加入容器
    @Bean
    public MainCaculator mainCaculator(){
        return new MainCaculator();
    }
    //将切面类加入容器
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
