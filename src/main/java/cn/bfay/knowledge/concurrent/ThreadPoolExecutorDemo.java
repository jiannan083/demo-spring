package cn.bfay.knowledge.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutorDemo.
 *
 * @author wangjiannan
 * @since 2019/12/26
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4,
            1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));

        RunnableDemo runnableDemo = new RunnableDemo();
        for (int i = 0; i < 10; i++) {
            pool.execute(runnableDemo);
            System.out.println("----" + pool.getPoolSize());
        }
    }

}
