package com.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 接口实现bean生命周期管理
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat...constructor");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("cat.DisposableBean.destroy");
    }

    /**
     * bean创建完成，属性赋值好后，调用初始化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat.InitializingBean.afterPropertiesSet");
    }
}
