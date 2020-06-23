package cn.bfay.sourcecode;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * MyBean.
 *
 * @author wangjiannan
 * @since 2019/11/27
 */
public class MyBean implements BeanFactoryPostProcessor {
    //public class MyBean implements BeanFactoryPostProcessor {
    public void sayHello() {
        System.out.println("-----hello");
    }

    // 所有的 Bean 都加载、注册完成了，但是都还没有初始化
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("----------------I am postProcessBeanFactory");
    }
}
