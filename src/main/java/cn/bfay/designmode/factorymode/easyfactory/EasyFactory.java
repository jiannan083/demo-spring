package cn.bfay.designmode.factorymode.easyfactory;

import cn.bfay.designmode.factorymode.Desk;
import cn.bfay.designmode.factorymode.PlasticDesk;
import cn.bfay.designmode.factorymode.WoodenDesk;

/**
 * EasyFactory.
 *
 * @author wangjiannan
 * @since 2019/12/3
 */
public class EasyFactory {
    public static Desk createDesk(String name) {
        if ("plastic".equals(name)) {
            return new PlasticDesk();
        } else if ("wooden".equals(name)) {
            return new WoodenDesk();
        } else {
            return null;
        }
    }
}
