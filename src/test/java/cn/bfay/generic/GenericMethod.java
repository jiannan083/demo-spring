package cn.bfay.generic;

import java.util.List;
import java.util.Map;

/**
 * 泛型方法.
 *
 * @author wangjiannan
 */
public class GenericMethod {
    // 定义泛型方法，其格式是：修饰符 <类型参数列表> 返回类型 方法名(形参列表) { 方法体 };
    // T和S是泛型类型参数;
    // 泛型方法的定义和普通方法定义不同的地方在于需要在修饰符和返回类型之间加一个泛型类型参数的声明，表明在这个方法作用域中谁才是泛型类型参数
    public static <T, S> void func(List<T> list, Map<String, S> map) {
        list.forEach(System.out::println);

        //T t= list.get(0);
        //S s = map.get("name");
        //
        //System.out.println(t);
        //System.out.println(s);
    }
}
