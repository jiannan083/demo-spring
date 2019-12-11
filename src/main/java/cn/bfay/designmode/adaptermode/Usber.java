package cn.bfay.designmode.adaptermode;

/**
 * USB接口实现类：Usber.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class Usber implements Usb {
    @Override
    public void isUsb() {
        System.out.println("USB口");
    }
}
