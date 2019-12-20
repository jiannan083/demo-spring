package cn.bfay.knowledge.concurrent;

/**
 * ThreadDemo.
 *
 * @author wangjiannan
 * @since 2019/12/19
 */
public class ThreadDemo extends Thread {
    private int count = 10;

    @Override
    public void run() {
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + "----" + count);
        }
    }

    public static void main(String[] args) {
        new ThreadDemo().start();
        new ThreadDemo().start();
        System.out.println(Thread.currentThread().getName() + "------开始-----");
    }
}
