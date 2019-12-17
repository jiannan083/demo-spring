package cn.bfay.knowledge.designmode.adaptermode;

/**
 * AdapterModeTest.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class AdapterModeTest {
    public static void main(String[] args) {
        // 类适配器
        Ps2 p1 = new AdapterClass();
        p1.isPs2();

        // 对象适配器
        Ps2 p2 = new AdapterObject(new Usber());
        p2.isPs2();
    }
}
