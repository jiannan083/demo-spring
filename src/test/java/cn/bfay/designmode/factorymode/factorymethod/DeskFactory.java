package cn.bfay.designmode.factorymode.factorymethod;

import cn.bfay.designmode.factorymode.Desk;

/**
 * 桌子工厂接口：DeskFactory.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public interface DeskFactory {
    Desk createDesk();
}
