package cn.bfay.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * CallableDemo.
 *
 * @author wangjiannan
 * @since 2019/12/26
 */
public class CallableDemo {
    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callable";
            }
        };

        FutureTask<String> task = new FutureTask<>(callable);

        // 创建线程
        new Thread(task).start();

        String result = null;
        try {
            // 调用get()阻塞主线程，反之，线程不会阻塞
            result = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("------------" + result);
    }
}
