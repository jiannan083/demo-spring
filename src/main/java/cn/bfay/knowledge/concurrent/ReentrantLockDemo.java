package cn.bfay.knowledge.concurrent;

/**
 * SynchronizedDemo多线程并发中Synchronized一直是元老级角色，很多人都会称呼它为
 * 重量级锁，随着JDK1.6对Synchronized进行了各种优化，有些情况它就并不那么重了.
 * <p>
 * synchronized不能被继承
 * <p>
 * Synchronized的作用：
 * （1）确保线程互斥的访问同步代码
 * （2）保证共享变量的修改能够及时可见
 * （3）有效解决重排序问题
 * <p>
 * Synchronized用法：
 * （1）修饰普通方法，锁是当前实例对象
 * public synchronized void add(){System.out.println("普通方法同步");}
 * （2）修饰静态方法，锁是当前类的Class对象
 * public static synchronized void put(){System.out.println("静态方法同步");}
 * （3）修饰代码块，锁是Synchronized括号里面配置的对象
 * public void set(){synchronized(this){System.out.println("代码块同步");}}
 * <p>
 * 每个对象有一个监视器锁（monitor）。当monitor被占用时就会处于锁定状态。
 * <p>
 * 关于方法的同步：可以看到相对于普通方法，其常量池中多了ACC_SYNCHRONIZED标示符，
 * JVM就是根据该标示符来实现方法的同步的，当方法调用时，调用指令将会检查方法的
 * ACC_SYNCHRONIZED 访问标志是否被设置，如果设置了，执行线程将先获取monitor，
 * 获取成功之后才能执行方法体，方法执行完后再释放monitor。在方法执行期间，其他任
 * 何线程都无法再获得同一个monitor对象。
 * <p>
 * 关于同步块的同步：线程执行monitorenter指令时尝试获取monitor的所有权，
 * 执行monitorexit其他被这个monitor阻塞的线程可以尝试去获取这个 monitor 的所有权
 * <p>
 * Synchronized的语义底层是通过一个monitor的对象来完成，其实wait/notify等方法
 * 也依赖于monitor对象，这就是为什么只有在同步的块或者方法中才能调用wait/notify等方法，
 * 否则会抛出java.lang.IllegalMonitorStateException的异常的原因。
 * <p>
 * 现在我们应该知道，Synchronized是通过对象内部的一个叫做监视器锁（monitor）来实现的。
 * 但是监视器锁本质又是依赖于底层的操作系统的Mutex Lock来实现的。而操作系统实现线程之间的
 * 切换这就需要从用户态转换到核心态，这个成本非常高，状态之间的转换需要相对比较长的时间，
 * 这就是为什么Synchronized效率低的原因。JDK1.6以后，为了减少获得锁和释放锁所带来的性能消耗，
 * 提高性能，引入了“偏向锁”和“轻量级锁”
 *
 * @author wangjiannan
 * @since 2019/12/23
 */
public class SynchronizedDemo implements Runnable {
    private int ticketNumber;

    public SynchronizedDemo(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public void run() {
        while (true) {
            // synchronized (this) 锁住当前对象，this即是当前对象 --> synchronizedDemo
            // synchronized (SynchronizedDemo.class) 锁当前类
            synchronized (SynchronizedDemo.class) {
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
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo(getTicketNUmber());
        //当两个并发线程(t1和t2)访问同一个对象(synchronizedDemo)中的synchronized代码块时，
        //在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后
        //才能执行该代码块。Thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的
        //对象，只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象。
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
        return 200;
    }
}
