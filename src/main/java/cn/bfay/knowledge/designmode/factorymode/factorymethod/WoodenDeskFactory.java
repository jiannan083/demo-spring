package cn.bfay.knowledge.designmode.factorymode.factorymethod;

import cn.bfay.knowledge.designmode.factorymode.Desk;
import cn.bfay.knowledge.designmode.factorymode.WoodenDesk;

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
