package cn.bfay.knowledge.designmode.factorymode.factorymethod;

import cn.bfay.knowledge.designmode.factorymode.Desk;

/**
 * 桌子工厂接口：DeskFactory.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public interface DeskFactory {
    Desk createDesk();
}
