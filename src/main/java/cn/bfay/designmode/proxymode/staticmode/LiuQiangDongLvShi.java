package cn.bfay.designmode.proxymode.staticmode;

import cn.bfay.designmode.proxymode.LiuQiangDong;
import cn.bfay.designmode.proxymode.ZiRanRen;

/**
 * 代理律师：LiuQiangDongLvShi.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class LiuQiangDongLvShi implements ZiRanRen {
    @Override
    public void quanli() {
        new LiuQiangDong().quanli();
    }
}
