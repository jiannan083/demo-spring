package cn.bfay.designmode.factorymode.factorymethod;

import cn.bfay.designmode.factorymode.Desk;
import cn.bfay.designmode.factorymode.PlasticDesk;

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
