package cn.bfay.designmode.proxymode.dynamicmode.cglib;

/**
 * CglibTest.
 *
 * @author wangjiannan
 * @since 2019/11/29
 */
public class CglibTest {
    public static void main(String[] args) {
        UserServiceCglib cglib = new UserServiceCglib();
        UserServiceImpl userServiceImpl = (UserServiceImpl) cglib.getInstance(new UserServiceImpl());
        userServiceImpl.addUser();
    }
}
