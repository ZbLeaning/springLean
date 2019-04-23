package com.imooc.condition;

import com.imooc.bean.RainRow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *AnnotationMetadata:当前类的注解信息
     * BeanDefinitionRegistry：BeanDefintion注册类
     *  把所有需要添加到容器中的bean：调用
     *  beanDefinitionRegistry.registerBeanDefinition 手工注册进来
     *@param annotationMetadata
     * @param beanDefinitionRegistry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.imooc.bean.Red");
        if (red){
            //指定Bean定义信息
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainRow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
