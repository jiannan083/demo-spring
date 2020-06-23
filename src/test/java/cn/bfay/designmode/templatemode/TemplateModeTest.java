package cn.bfay.designmode.templatemode;

/**
 * TemplateModeTest.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public class TemplateModeTest {
    public static void main(String[] args) {
        HouseTemplate houseOne = new HouseOne("房子1");
        HouseTemplate houseTwo = new HouseTwo("房子2");
        houseOne.buildHouse();
        System.out.println();
        houseTwo.buildHouse();
        System.out.println();

        HouseTemplate houseOne1 = new HouseOne("房子1", true);
        houseOne1.buildHouse();
    }
}
