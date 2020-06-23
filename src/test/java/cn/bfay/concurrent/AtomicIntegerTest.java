package cn.bfay.concurrent;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicIntegerTest.
 *
 * @author wangjiannan
 * @since 2019/12/17
 */
public class AtomicIntegerTest {

    @Test
    public void test() {
        AtomicInteger ai = new AtomicInteger(0);
        int i = ai.incrementAndGet();
        System.out.println("-------" + i);
        //ai.addAndGet(1);
        //ai.getAndAdd(1);
    }
}
