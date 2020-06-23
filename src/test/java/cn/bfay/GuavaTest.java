package cn.bfay;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * GuavaTest.
 *
 * @author wangjiannan
 */
public class GuavaTest {
    @Test
    public void testCreateCollection() {
        // 1--普通Collection的创建
        List<String> list = Lists.newArrayList("da", "ea");
        Set<String> set = Sets.newHashSet("da", "ea");
        Map<String, String> map = Maps.newHashMap();

        // 2--不变Collection的创建
        // immutable(不可变)对象,在多线程操作下，是线程安全的;所有不可变集合会比可变集合更有效的利用资源;中途不可改变
        // 类中的 操作集合的方法（譬如add, set, sort, replace等）都被声明过期，并且抛出异常
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        //iList.add("fsda");
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

        // 3--一个map中包含key为String类型，value为List类型的时候
        // java
        Map<String, List<Integer>> map3 = new HashMap<>();
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        map3.put("aa", list3);
        System.out.println(map3.get("aa"));//[1, 2]
        // guava
        Multimap<String, Integer> map33 = ArrayListMultimap.create();
        map33.put("aa", 1);
        map33.put("aa", 2);
        System.out.println(map33.get("aa"));  //[1, 2]
        // 其他的黑科技集合
        // MultiSet: 无序+可重复   count()方法获取单词的次数  增强了可读性+操作简单
        // 创建方式:  Multiset<String> set = HashMultiset.create();
        //
        // Multimap: key-value  key可以重复
        // 创建方式: Multimap<String, String> teachers = ArrayListMultimap.create();
        //
        // BiMap: 双向Map(Bidirectional Map) 键与值都不能重复
        // 创建方式:  BiMap<String, String> biMap = HashBiMap.create();
        //
        // Table: 双键的Map Map--> Table-->rowKey+columnKey+value  // 和sql中的联合主键有点像
        // 创建方式: Table<String, String, Integer> tables = HashBasedTable.create();

        // 4--将集合转换为特定规则的字符串
        //use java
        List<String> list4 = new ArrayList<>();
        list4.add("aa");
        list4.add("bb");
        list4.add("cc");
        String str4 = "";
        for (int i = 0, size = list4.size(); i < size; i++) {
            str4 = str4 + "-" + list4.get(i);
        }
        //str 为-aa-bb-cc
        // use guava
        List<String> list44 = new ArrayList<>();
        list44.add("aa");
        list44.add("bb");
        list44.add("cc");
        String result4 = Joiner.on("-").join(list44);
        //result为  aa-bb-cc

        // 5--map集合转换为特定规则的字符串
        Map<String, Integer> map5 = Maps.newHashMap();
        map5.put("xiaoming", 12);
        map5.put("xiaohong", 13);
        String result5 = Joiner.on(",").withKeyValueSeparator("=").join(map5);
        // result为 xiaoming=12,xiaohong=13
        // 将String转换为map
        String str55 = "xiaoming=11,xiaohong=23";
        Map<String, String> map55 = Splitter.on(",").withKeyValueSeparator("=").split(str55);

        // 6--将String转换为特定的集合
        //use java
        List<String> list6 = new ArrayList<>();
        String a6 = "1-2-3-4-5-6";
        String[] strs6 = a6.split("-");
        for (int i = 0, length = strs6.length; i < length; i++) {
            list6.add(strs6[i]);
        }
        // list6.addAll(Arrays.asList(strs6));
        //use guava
        String str66 = "1-2-3-4-5-6";
        List<String> list66 = Splitter.on("-").splitToList(str66);
        //list为  [1, 2, 3, 4, 5, 6]
        // 如果str="1-2-3-4- 5-  6  ",guava还可以使用 omitEmptyStrings().trimResults() 去除空串与空格
        String str666 = "1-2-3-4-  5-  6   ";
        List<String> list666 = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str666);
        System.out.println(list666);

        // 7--guava还支持多个字符切割，或者特定的正则分隔
        String input7 = "aa.dd,,ff,,.";
        List<String> result7 = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(input7);
        // 字符串的操作 都是在Splitter这个类上进行的
        // 判断匹配结果
        boolean result = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).matches('K'); //true
        // 保留数字文本  CharMatcher.digit() 已过时   retain 保留
        //String s1 = CharMatcher.digit().retainFrom("abc 123 efg"); //123
        String s1 = CharMatcher.inRange('0', '9').retainFrom("abc 123 efg"); // 123
        // 删除数字文本  remove 删除
        // String s2 = CharMatcher.digit().removeFrom("abc 123 efg");    //abc  efg
        String s2 = CharMatcher.inRange('0', '9').removeFrom("abc 123 efg"); // abc  efg
    }

    @Test
    public void testCollectionFilter() {
        //按照条件过滤
        ImmutableList<String> names = ImmutableList.of("begin", "code", "Guava", "Java");
        Iterable<String> fitered = Iterables.filter(names, Predicates.or(Predicates.equalTo("Guava"), Predicates.equalTo("Java")));
        System.out.println(fitered); // [Guava, Java]

        //自定义过滤条件   使用自定义回调方法对Map的每个Value进行操作
        ImmutableMap<String, Integer> m = ImmutableMap.of("begin", 12, "code", 15);
        // Function<F, T> F表示apply()方法input的类型，T表示apply()方法返回类型
        Map<String, Integer> m2 = Maps.transformValues(m, new Function<Integer, Integer>() {
            public Integer apply(Integer input) {
                if (input > 12) {
                    return input;
                } else {
                    return input + 1;
                }
            }
        });
        System.out.println(m2);   //{begin=13, code=15}
    }


}
