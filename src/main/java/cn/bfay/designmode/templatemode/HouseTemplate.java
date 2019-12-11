package cn.bfay.designmode.templatemode;

/**
 * HouseTemplate.
 *
 * @author wangjiannan
 * @since 2019/11/28
 */
public abstract class HouseTemplate {
    protected String name;

    protected HouseTemplate(String name) {
        this.name = name;
    }

    protected abstract void buildDoor();

    protected abstract void buildWindow();

    protected abstract void buildWall();

    protected abstract void buildBase();

    protected abstract void buildToilet();

    //钩子方法
    protected boolean isBuildToilet() {
        return true;
    }

    //公共逻辑
    public final void buildHouse() {
        buildBase();
        buildWall();
        buildDoor();
        buildWindow();
        if (isBuildToilet()) {
            buildToilet();
        }
    }
}
