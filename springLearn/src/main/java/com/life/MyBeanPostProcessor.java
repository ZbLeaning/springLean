package com.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器
 * 将其加入到容器中
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 初始化之前
     * @param beanName 容器创建好的实例
     * @param bean  该实例在容器中的名字
     * @return  返回值是将要返回的要用的bean实例，也可以包装后返回
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
        return bean;
    }

    /**
     * 初始化之后
     * @param beanName
     * @param bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
        return bean;
    }
}
