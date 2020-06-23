package cn.bfay.concurrent;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MapDemo.
 *
 * @author wangjiannan
 * @since 2019/12/17
 */
public class MapDemo {
    public static void main(String[] args) {
        //hashMapDemo();
        concurrentHashMapDemo();
    }

    private static void hashMapDemo() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "e");
        map.put("7", "e");
        map.put("8", "e");
        map.put("9", "e");
        map.put("10", "e");
        map.put("11", "e");
        map.put("12", "e"); // 默认初始化大小为16个，加载因子0.75 ===> 阀值 0.75 * 16=12
        map.put("13", "e"); // size=13>阀值12 扩容 到32
        System.out.println("-----size=" + map.size());
        System.out.println("-----map.get(\"12\")=" + map.get("12"));
    }

    private static void hashTableDemo() {
        Map<String, String> table = new Hashtable<>();
        table.put("1", "a");
    }

    private static void concurrentHashMapDemo() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "a");
        map.put("2", "b");

        System.out.println("-----size=" + map.size());
        System.out.println("-----map.get(\"1\")=" + map.get("1"));
    }
}
