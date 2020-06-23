package cn.bfay.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 泛型.
 *
 * @author wangjiannan
 */
public class GenericTest {

    @Test
    public void testGeneric() {
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        System.out.println(l1.getClass());
        System.out.println(l2.getClass());
        System.out.println(l1.getClass() == l2.getClass());
    }

    @Test
    public void testGenericClass() {
        GenericClass<String, String> genericClass1 = new GenericClass<>("a", "b");
        System.out.println(genericClass1.getK() + genericClass1.getV());

        GenericClass<String, Integer> genericClass2 = new GenericClass<>("a", 1);
        System.out.println(genericClass2.getK() + genericClass2.getV());

    }

    @Test
    public void testGenericMethod() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        List<Integer> list1 = new ArrayList<>();
        list1.add(111);
        list1.add(222);
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        GenericMethod.func(list, map);
        GenericMethod.func(list1, map);

    }


}
