package com.imooc.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 是否是linux系统
 */
public class LinuxCondition implements Condition {
    /**
     * ConditionContext：判断条件能使用的上下文
     * AnnotatedTypeMetadata: 标注了Condition注解的注释信息
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取到ioc使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取到类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String osName = environment.getProperty("os.name");
        if (osName.contains("Linux")){
            return true;
        }
        return false;
    }
}
