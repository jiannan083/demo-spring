package cn.bfay;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMapTest.
 *
 * @author wangjiannan
 * @since 2019/12/17
 */
public class ConcurrentHashMapTest {


    @Test
    public void test() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("aaa", "aaa");

        map.get("aaa");

    }
}
