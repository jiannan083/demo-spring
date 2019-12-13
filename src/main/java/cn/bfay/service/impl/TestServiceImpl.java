package cn.bfay.service.impl;

import cn.bfay.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * TestServiceImpl.
 *
 * @author wangjiannan
 * @since 2019/12/13
 */
@Service
public class TestServiceImpl implements TestService {
    // context的
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void test() {
        System.out.println("displayName-----" + applicationContext.getDisplayName());
        System.out.println("beanDefinitionCount-----" + applicationContext.getBeanDefinitionCount());
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);
    }
}
