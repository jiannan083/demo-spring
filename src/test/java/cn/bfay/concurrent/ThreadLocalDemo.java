package cn.bfay.concurrent;

import org.junit.Test;

/**
 * ThreadLocalDemo.
 *
 * @author wangjiannan
 * @since 2019/12/17
 */
public class ThreadLocalDemo extends Thread {
    @Override
    public void run() {
        ThreadLocal<String> local = new ThreadLocal<>();
        ThreadLocal<String> local1 = new ThreadLocal<>();
        ThreadLocal<String> local2 = new ThreadLocal<>();
        local.set("anv");
        local1.set("anv1");
        local2.set("anv");
        System.out.println("-------" + local.get());
        System.out.println("-------" + local1.get());
        System.out.println("-------" + local2.get());
        local.remove();
    }


    @Test
    public void test() throws InterruptedException {
        Thread thread = new ThreadLocalDemo();
        thread.start();
        thread.join();
    }
}
