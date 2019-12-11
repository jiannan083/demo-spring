package cn.bfay;

import org.springframework.context.annotation.Bean;

/**
 * AnnotationBean.
 *
 * @author wangjiannan
 * @since 2019/12/2
 */
//@Configuration
//@Order(value = 2)
public class AnnotationBean {
    @Bean(name = "myBean")
    public MyBean getMyBean() {
        return new MyBean();
    }

    //@Bean(name = "myBean1")
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