package com.component.importConfig;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑 返回需要导入的组件
 * 注册Yellow的bean
 */
public class MyImportSelector implements ImportSelector {
    //返回值，是要导入到容器中的组件全类名
    //AnnotationMetadata：当前标注@Import注解类的所有信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //该方法不可以返回null
        return new String[]{"com.component.pojo.Yellow"};
    }
}
