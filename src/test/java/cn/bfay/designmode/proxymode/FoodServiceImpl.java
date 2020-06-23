package cn.bfay.designmode.proxymode;

/**
 * FoodServiceImpl.
 *
 * @author wangjiannan
 * @since 2019/11/29
 */
public class FoodServiceImpl implements FoodService {
    @Override
    public void makeChicken() {
        System.out.println("制作鸡过程");
    }

    @Override
    public void makeNoodle() {
        System.out.println("制作面条过程");
    }
}
