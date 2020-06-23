package cn.bfay.concurrent;

/**
 * JoinDemo.
 * join()是使线程同步，如在某个线程里调用t.join()表示t线程执行完再执行当前线程
 *
 * @author wangjiannan
 * @since 2019/12/25
 */
public class JoinDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-----join");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinDemo());
        thread.start();
        thread.join();
        System.out.println(Thread.currentThread().getName() + "-----main");
    }
}
