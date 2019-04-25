package com.component.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Conditional的条件之一，当前系统是Windows才加载注释的bean
 * true：满足条件
 */
public class ConditionalWindows implements Condition {
    /**
     * ConditionContext：判断条件能使用的上下文
     * AnnotatedTypeMetadata: 标注了Condition注解的注释信息
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取当前环境，并获取当前系统类型
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        if (osName.contains("Windows")){
            return true;
        }
        return false;
    }
}
