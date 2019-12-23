package cn.bfay.knowledge.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * RunnableDemo.
 *
 * @author wangjiannan
 * @since 2019/12/19
 */
public class RunnableDemo implements Runnable {
    private int number = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // =========方式1
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "----" + number++);
        }
        // =========方式2
        //lock.lock();
        //try {
        //    System.out.println(Thread.currentThread().getName() + "----" + number++);
        //} finally {
        //    //用try finally块保证Unlock一定要执行
        //    lock.unlock();
        //}

        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "------开始-----");
        RunnableDemo runnableDemo = new RunnableDemo();
        for (int i = 0; i < 500; i++) {
            new Thread(runnableDemo).start();
        }
    }
}
