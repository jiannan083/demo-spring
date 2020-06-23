package cn.bfay;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMapTest.
 *
 * @author wangjiannan
 * @since 2019/12/17
 */
public class HashMapTest {


    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("aaa", "aaa");

        map.get("aaa");

    }
}
