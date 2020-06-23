package cn.bfay.java8;

import org.junit.Test;

import java.time.Clock;

/**
 * Date/Time.
 *
 * @author wangjiannan
 */
public class DateAndTimeTest {

    @Test
    public void test() {
        // Get the system clock as UTC offset
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
    }
}
