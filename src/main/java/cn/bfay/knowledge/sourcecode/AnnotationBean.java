package cn.bfay.knowledge.sourcecode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AnnotationBean.
 *
 * @author wangjiannan
 * @since 2019/12/2
 */
// 加上注解@Configuration，包扫描的时候就会把里面的bean注册
//从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，
// 被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被
// AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext
// 类进行扫描，并用于构建bean定义，初始化Spring容器。
//注意：@Configuration注解的配置类有如下要求：
//@Configuration不可以是final类型；
//@Configuration不可以是匿名类；
//嵌套的configuration必须是静态类。
@Configuration
//@Order(value = 2)
public class AnnotationBean {
    @Bean(name = "myBean")
    public MyBean getMyBean() {
        return new MyBean();
    }

    // 错误的
    //@Bean(name = "myBean1") 需要返回bean
    //public void getMyBean1() {
    //    System.out.println("--------myBean1");
    //}

    @Bean(name = "myBean1")
    public MyBean1 getMyBean1() {
        return new MyBean1();
    }

    @Bean(name = "myBean2")
    public MyBean2 getMyBean2() {
        return new MyBean2();
    }
}