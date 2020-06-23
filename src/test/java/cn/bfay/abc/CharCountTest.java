package cn.bfay.abc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * CharCountTest.
 *
 * @author wangjiannan
 * @since 2019/12/31
 */
public class CharCountTest {

    @Test
    public void test() {
        String str = "fdsfdsrgbadfjasihdsaghfdsahfasjdkf";

        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        System.out.println(map);
        //System.out.println(str.length());


        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            stack.push(c);
        }


        for (int i = 0; i < str.length(); i++) {
            System.out.print(stack.pop());
        }
        //Iterator<Character> iterator = stack.iterator();
        ////iterator.hasNext()如果存在元素的话返回true
        //while(iterator.hasNext()) {
        //    //iterator.next()返回迭代的下一个元素
        //    System.out.print(iterator.next());
        //}
        System.out.println();
        System.out.println(new StringBuffer(str).reverse().toString());
    }
}
