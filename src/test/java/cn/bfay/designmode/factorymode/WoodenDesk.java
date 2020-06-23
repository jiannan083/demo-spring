package cn.bfay.designmode.factorymode;

/**
 * 木质桌子：WoodenDesk.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class WoodenDesk implements Desk {
    @Override
    public void getType() {
        System.out.println("木质桌");
    }
}
