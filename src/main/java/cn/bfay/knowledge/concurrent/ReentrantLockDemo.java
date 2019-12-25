package cn.bfay.knowledge.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantLockDemo.
 *
 * @author wangjiannan
 * @since 2019/12/23
 */
public class ReentrantLockDemo implements Runnable {
    private Lock lock = new ReentrantLock();

    private int ticketNumber;

    public ReentrantLockDemo(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticketNumber > 0) {
                    // 休眠50毫秒模拟处理车票时间
                    Thread.sleep(50);
                    System.out.println(Thread.currentThread().getName() + "卖票-->" + ticketNumber--);
                } else {
                    System.out.println(Thread.currentThread().getName() + "已经卖完...");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo synchronizedDemo = new ReentrantLockDemo(getTicketNUmber());
        Thread t1 = new Thread(synchronizedDemo, "1号窗口");
        Thread t2 = new Thread(synchronizedDemo, "2号窗口");
        Thread t3 = new Thread(synchronizedDemo, "3号窗口");
        Thread t4 = new Thread(synchronizedDemo, "4号窗口");
        Thread t5 = new Thread(synchronizedDemo, "5号窗口");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static int getTicketNUmber() {
        // 数据库查询票数
        return 50;
    }
}
