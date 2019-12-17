package cn.bfay.knowledge.designmode.proxymode.staticmode;

import cn.bfay.knowledge.designmode.proxymode.MaYun;
import cn.bfay.knowledge.designmode.proxymode.ZiRanRen;

/**
 * 代理律师：MaYunLvShi.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class MaYunLvShi implements ZiRanRen {
    @Override
    public void quanli() {
        new MaYun().quanli();
    }
}
