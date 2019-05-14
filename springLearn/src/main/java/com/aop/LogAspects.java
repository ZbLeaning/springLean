package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;


/**
 * 切面类
 * @Aspect：告诉spring容器，当前类是一个切面
 */

@Aspect
public class LogAspects {
    //抽取公共的切入点表达式
    @Pointcut("execution(public int com.aop.MainCaculator.*(..))")
    public void pointCut(){}

    //指定在哪个方法前切入
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"运行。。。参数是:{"+ Arrays.asList(joinPoint.getArgs())+"}");
    }
    @After("pointCut()")
    public void logStop(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"结束。。。");
    }
    @AfterReturning(value = "pointCut()()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"正常运行。。。运行结果是是:{"+result+"}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"异常。。。异常信息是:{"+exception+"}");
    }

}
