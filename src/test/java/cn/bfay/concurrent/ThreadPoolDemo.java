package cn.bfay.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadPoolDemo.
 *
 * @author wangjiannan
 * @since 2019/12/26
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 获取计算机有几个核
        int processors = Runtime.getRuntime().availableProcessors();

        // LinkedBlockingQueue 定义的queue的capacity为Integer.MAX_VALUE，会堆积大量的请求，从而导致OOM
        ExecutorService executor1 = Executors.newFixedThreadPool(10);

        // SynchronousQueue 定义的maximumPoolSize为Integer.MAX_VALUE，创建大量的线程，从而导致OOM
        ExecutorService executor2 = Executors.newCachedThreadPool();

        // LinkedBlockingQueue 定义的queue的capacity为Integer.MAX_VALUE，会堆积大量的请求，从而导致OOM
        ExecutorService executor3 = Executors.newSingleThreadExecutor();

        //DelayedWorkQueue
        ExecutorService executor4 = Executors.newScheduledThreadPool(10);
    }

}
