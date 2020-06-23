package cn.bfay.designmode.proxymode.staticmode;

import cn.bfay.designmode.proxymode.FoodService;
import cn.bfay.designmode.proxymode.LiuQiangDong;
import cn.bfay.designmode.proxymode.ZiRanRen;

/**
 * StaticModeTest.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class StaticModeTest {
    public static void main(String[] args) {
        ZiRanRen ls1 = new MaYunLvShi();
        ls1.quanli();

        // 静态代理
        // 1.ZiRanRen --> 接口 ----> 类比Runnable
        // 2.LiuQiangDongLvShi --> 代理类 ----> 类比Thread
        // 3.LiuQiangDong --> 具体实现类 ----> 类比MyThread
        LiuQiangDongLvShi ls2 = new LiuQiangDongLvShi(new LiuQiangDong());
        ls2.quanli();

        // 这里用代理类来实例化
        FoodService foodService = new FoodServiceProxy();
        foodService.makeChicken();
    }
}
