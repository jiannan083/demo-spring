package cn.bfay.designmode.proxymode.dynamicmode.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * UserServiceCglib.
 *
 * @author wangjiannan
 * @since 2019/11/29
 */
public class UserServiceCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    /**
     * 实现MethodInterceptor接口中重写的方法
     * <p>
     * 回调方法
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("事务开始。。。");
        Object result = proxy.invokeSuper(object, args);
        System.out.println("事务结束。。。");
        return result;
    }

}
