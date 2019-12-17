package cn.bfay.knowledge.designmode.factorymode;

/**
 * 塑料桌子：PlasticDesk.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class PlasticDesk implements Desk {
    @Override
    public void getType() {
        System.out.println("塑料桌");
    }
}
