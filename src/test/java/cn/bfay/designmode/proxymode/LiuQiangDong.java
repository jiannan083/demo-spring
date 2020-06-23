package cn.bfay.designmode.proxymode;

/**
 * 委托人：LiuQiangDong.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class LiuQiangDong implements ZiRanRen {
    //public void eat() {
    //    System.out.println("今天吃满汉全席");
    //}
    //
    //public void drink() {
    //    System.out.println("今天喝大西洋");
    //}

    @Override
    public void quanli() {
        System.out.println("LQD赋予我的代理律师来行使这些权利,此时代理律师全权代理我处理某些事务");
    }
}
