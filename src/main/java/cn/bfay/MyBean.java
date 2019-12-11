package cn.bfay;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * MyBean.
 *
 * @author wangjiannan
 * @since 2019/11/27
 */
public class MyBean implements BeanFactoryPostProcessor, BeanPostProcessor {
//public class MyBean implements BeanFactoryPostProcessor {
    public void sayHello() {
        System.out.println("-----hello");
    }

    // 所有的 Bean 都加载、注册完成了，但是都还没有初始化
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("----------------I am postProcessBeanFactory");
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
