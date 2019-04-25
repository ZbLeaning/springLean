package com.component.importConfig;

import com.component.pojo.Blue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 如果有指定bean被注册，则手工注册另一个指定bean
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *  AnnotationMetadata:当前类的注解信息
     *  BeanDefinitionRegistry：BeanDefintion注册类
     *  把所有需要添加到容器中的bean：调用
     *  beanDefinitionRegistry.registerBeanDefinition 手工注册进来
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //如果被注册的容器中有指定的bean 则手工注册指定bean
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.component.pojo.Red");
        if (red){
            //指定Bean定义信息
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Blue.class);
            beanDefinitionRegistry.registerBeanDefinition("blue",rootBeanDefinition);
        }
    }
}
