package cn.bfay.designmode.adaptermode;

/**
 * 对象适配器：Adapter.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class AdapterObject implements Ps2 {
    private Usb usb;

    public AdapterObject(Usb usb) {
        this.usb = usb;
    }

    @Override
    public void isPs2() {
        usb.isUsb();
    }
}
