package cn.bfay.concurrent;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * ThreadPoolTaskExecutorDemo.
 *
 * @author wangjiannan
 * @since 2019/12/26
 */
public class ThreadPoolTaskExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(2);
        pool.setMaxPoolSize(4);
        pool.setKeepAliveSeconds(2);
        pool.setQueueCapacity(4);
        pool.initialize();

        RunnableDemo runnableDemo = new RunnableDemo();
        for (int i = 0; i < 2; i++) {
            pool.execute(runnableDemo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
