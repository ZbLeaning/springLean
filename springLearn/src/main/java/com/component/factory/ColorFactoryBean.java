package com.component.factory;

import com.component.pojo.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * spring自定义FactoryBean
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    //返回一个Color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
    //是单例？ true：这个bean是单实例，在容器中只保存一份
    //false：多实例，每次获取都会创建一个新的
    @Override
    public boolean isSingleton() {
        return true;
    }
}
