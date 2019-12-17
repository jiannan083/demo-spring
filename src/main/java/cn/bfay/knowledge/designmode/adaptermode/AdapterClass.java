package cn.bfay.knowledge.designmode.adaptermode;

/**
 * 类适配器：AdapterClass.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class AdapterClass extends Usber implements Ps2 {

    @Override
    public void isPs2() {
        //System.out.println("Ps2口");
        isUsb();
    }

}
