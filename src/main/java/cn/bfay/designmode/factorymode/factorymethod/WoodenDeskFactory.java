package cn.bfay.designmode.factorymode.factorymethod;

import cn.bfay.designmode.factorymode.Desk;
import cn.bfay.designmode.factorymode.WoodenDesk;

/**
 * 木质桌子工厂：WoodenDeskFactory.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class WoodenDeskFactory implements DeskFactory {
    @Override
    public Desk createDesk() {
        return new WoodenDesk();
    }
}
