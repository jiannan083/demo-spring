package cn.bfay.knowledge.designmode.factorymode.factorymethod;

import cn.bfay.knowledge.designmode.factorymode.Desk;

/**
 * FactoryMethodTest.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        DeskFactory factory = new WoodenDeskFactory();
        Desk desk = factory.createDesk();
        desk.getType();
    }
}
