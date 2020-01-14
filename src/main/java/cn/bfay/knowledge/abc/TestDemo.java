package cn.bfay.knowledge.abc;

/**
 * TestDemo.
 *
 * @author wangjiannan
 * @since 2020/1/2
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(calculate(30));

        System.out.println((1 - calculate(31)) / (1 - 2));

        System.out.println(calculate(31));

        System.out.println(calculate(31) - 1);
    }


    private static int calculate(int n) {
        if (n == 0) {
            return 1;
        }
        return 2 * calculate(n - 1);
    }
    // 2* c(4)
}
