package cn.bfay.designmode.proxymode.staticmode;

import cn.bfay.designmode.proxymode.ZiRanRen;

/**
 * 代理律师：LiuQiangDongLvShi.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class LiuQiangDongLvShi implements ZiRanRen {
    private ZiRanRen target;

    public LiuQiangDongLvShi(ZiRanRen target) {
        this.target = target;
    }

    @Override
    public void quanli() {
        target.quanli();
    }
}
