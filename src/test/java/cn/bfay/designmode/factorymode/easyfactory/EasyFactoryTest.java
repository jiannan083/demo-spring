package cn.bfay.designmode.factorymode.easyfactory;

import cn.bfay.designmode.factorymode.Desk;

/**
 * EasyFactoryTest.
 *
 * @author wangjiannan
 * @since 2019/12/3
 */
public class EasyFactoryTest {

    public static void main(String[] args) {
        Desk desk = EasyFactory.createDesk("plastic");
        desk.getType();
    }
}
