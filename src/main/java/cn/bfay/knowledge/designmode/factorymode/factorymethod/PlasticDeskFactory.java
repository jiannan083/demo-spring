package cn.bfay.knowledge.designmode.factorymode.factorymethod;

import cn.bfay.knowledge.designmode.factorymode.Desk;
import cn.bfay.knowledge.designmode.factorymode.PlasticDesk;

/**
 * 塑料桌子工厂：.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class PlasticDeskFactory implements DeskFactory {
    @Override
    public Desk createDesk() {
        return new PlasticDesk();
    }
}
