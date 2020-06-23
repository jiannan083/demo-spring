package cn.bfay.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchDemo.
 *
 * @author wangjiannan
 * @since 2019/12/26
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now() + "先行者执行结束，我开始指执行1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now() + "先行者执行结束，我开始指执行2");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now() + "先行者执行结束，我开始指执行3");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println(LocalDateTime.now() + "先行者执行完成...");
            }
        }).start();
    }
}
