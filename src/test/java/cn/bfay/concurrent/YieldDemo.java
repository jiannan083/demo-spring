package cn.bfay.concurrent;

/**
 * YieldDemo.
 * 暂停当前正在执行的线程对象，并执行其他线程。
 * Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其
 * 他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当
 * 的轮转执行。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有
 * 可能被线程调度程序再次选中。
 *
 * @author wangjiannan
 * @since 2019/12/25
 */
public class YieldDemo extends Thread {
    public YieldDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为5时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 5) {
                yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldDemo yieldDemo1 = new YieldDemo("线程1");
        YieldDemo yieldDemo2 = new YieldDemo("线程2");
        yieldDemo1.start();
        yieldDemo2.start();
    }
}
