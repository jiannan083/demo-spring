package cn.bfay.designmode.proxymode.staticmode;

import cn.bfay.designmode.proxymode.FoodService;
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

        ZiRanRen ls2 = new LiuQiangDongLvShi();
        ls2.quanli();

        // 这里用代理类来实例化
        FoodService foodService = new FoodServiceProxy();
        foodService.makeChicken();
    }
}
