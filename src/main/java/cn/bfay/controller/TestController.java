package cn.bfay.controller;

import cn.bfay.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * TestController.
 *
 * @author wangjiannan
 * @since 2019/12/11
 */
@Controller
public class TestController {
    // servlet的
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private TestService testService;

    @ResponseBody
    @GetMapping("/test")
    public String test() throws Exception {
        System.out.println("displayName-----" + applicationContext.getDisplayName());
        System.out.println("beanDefinitionCount-----" + applicationContext.getBeanDefinitionCount());
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);

        System.out.println("----------------");

        System.out.println("displayName-----" + applicationContext.getParent().getDisplayName());
        System.out.println("beanDefinitionCount-----" + applicationContext.getParent().getBeanDefinitionCount());
        String[] beanDefinitionNames1 = applicationContext.getParent().getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames1).forEach(System.out::println);

        System.out.println("----------------");
        //Class<?> aClass = Class.forName(beanDefinitionNames[0]);
        //System.out.println(applicationContext.getBean("myBean"));

        testService.test();
        return beanDefinitionNames[0];
        //return "I am test；我是测试";
    }

}
