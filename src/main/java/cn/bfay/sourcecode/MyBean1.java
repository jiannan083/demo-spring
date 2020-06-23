package cn.bfay.sourcecode;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * MyBean1.
 *
 * @author wangjiannan
 * @since 2019/11/27
 */
public class MyBean1 implements BeanPostProcessor {
    public int a = 111;

    public void myBean1() {
        System.out.println("----------" + a);
    }

    // , BeanPostProcessor
    //  bean 在初始化之前
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyBean1) {
            ((MyBean1) bean).a = 222;
            ((MyBean1) bean).myBean1();
        }
        System.out.println("----------------I am postProcessBeforeInitialization");
        return bean;
    }

    // 初始化完成之后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("----------------I am postProcessAfterInitialization");
        return bean;
    }
}
