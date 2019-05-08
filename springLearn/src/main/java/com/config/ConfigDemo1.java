package com.config;


import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 * 1、@Autowired：自动注入
 *      1.1、默认先按照类型去容器中找对应组件
 *      1.2、如果找到多个相同类型组件，再将属性的名称作为组件的id去容器中查找
 *      1.3、配合@Qualifier("指定bean的id")：指定要装配组件的id，而不是用属性名
 *      1.4、自动装配默认一定要将属性赋值好，否则没有就会报错
 *      1.5、@Autowired(required=false)：非必须装配，防止没有bean而报错
 *      1.6、@Primary：让spring自动装配时。默认使用被注解的首选的bean。
 *          也可继续使用@Qualifier，指定需要装配的bean的名字
 * 2、Spring支持使用@Resource(JSR250)和@Inject(JSR330) ---java规范注解
 *      @Resource：
 *          java规范，可以和@Autowired一样实现自动装配功能，默认按组件名称来装配
 *          通过设置 @Resource(name="")属性来指定装配组件，不支持@Primary和@Autowired(required=false)
 *      @Inject：
 *          java规范，需要导入javax.inject包，和@Autowired功能一样。
 *          @Inject没有@Autowired(required=false)功能。
 *  3、@Autowired：构造器，参数，方法，都是从容器中获取参数组件的值
 *      标注在方法：@Bean+方法参数，参数从容器中获取，默认不写@Autowired效果一样。都能自动装配
 *      标注在构造器：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以从容器中自动获取
 *      标注在参数位置：
 *
 *
 *  4、自定义组件想要使用Spring容器底层的组件（ApplicationContext，BeanFactory等等），自定义组件实现xxxAware
 *  5、@Profile：Spring为我们提供的可以根据当前环境，动态激活和切换一系列bean的功能
 */
@Configuration
public class ConfigDemo1 {

}
