package cn.bfay.knowledge.concurrent;

/**
 * WaitDemo.
 *
 * @author wangjiannan
 * @since 2019/12/25
 */
public class WaitDemo implements Runnable {
    private String name;
    private final Object prev;
    private final Object self;

    public WaitDemo(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        WaitDemo t1 = new WaitDemo("A", c, a);
        WaitDemo t2 = new WaitDemo("B", a, b);
        WaitDemo t3 = new WaitDemo("C", b, c);

        new Thread(t1).start();
        Thread.sleep(100);
        new Thread(t2).start();
        Thread.sleep(100);
        new Thread(t3).start();
        Thread.sleep(100);
    }
}
