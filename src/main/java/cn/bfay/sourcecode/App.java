package cn.bfay.sourcecode;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 */
public class App {

    public void fun() {
        // 同1，Spring 3.1 开始 XmlBeanFactory 已经被置为 Deprecated，推荐采用更加原生的方式
        Resource resource0 = new ClassPathResource("applicationContext.xml");
        XmlBeanFactory xmlBeanFactory0 = new XmlBeanFactory(resource0);
        MyBean myBean0 = (MyBean) xmlBeanFactory0.getBean("myBean");
        myBean0.sayHello();
        // 1.原生------------------------
        Resource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        MyBean myBean = (MyBean) beanFactory.getBean("myBean");
        myBean.sayHello();

        // 2.------------------------
        ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean1 = context1.getBean(MyBean.class);
        myBean1.sayHello();

        //WebApplicationContextUtils.
        // 3.------------------------这种方式只是加载配置文件,只有真正调用getBean()方法的时候,才会去实例化相应的对象,和前两者有些不同
        ApplicationContext context2 = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        MyBean myBean2 = context2.getBean(MyBean.class);
        myBean2.sayHello();

        //1.前两种方式
        //优点:在容器初始化的时候就会将所有对象创建完毕,获取对象的效率更高
        //缺点:占用内存

        //2.XmlBeanFactory方式
        //优点:节省内存
        //缺点:获取对象的效率相对来说会低

        String[] beanDefinitionNames = context2.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(">>>>>>" + name);
        }
        int beanDefinitionCount = context1.getBeanDefinitionCount();
        System.out.println("-----------beanDefinitionCount =" + beanDefinitionCount);

        // 注解：
        ApplicationContext context3 = new AnnotationConfigApplicationContext(AnnotationBean.class);
        MyBean1 myBean11 = (MyBean1) context3.getBean("myBean1");
        myBean11.myBean1();

    }
}
