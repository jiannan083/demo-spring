package cn.bfay.datastructure;

import org.junit.Test;

/**
 * TreeVistTest.
 *
 * @author wangjiannan
 * @since 2020/12/10
 */
public class TreeVistTest {
    @Test
    public void testTreeVist() {
        TreeNode tree = createTree();
        System.out.println("前序遍历：");
        preVist(tree);
        System.out.println();

        System.out.println("中序遍历：");
        midVist(tree);
        System.out.println();

        System.out.println("后序遍历：");
        postVist(tree);
        System.out.println();
    }

    // ABDEGCFHI
    private void preVist(TreeNode tree) {
        if (null != tree) {
            System.out.print(tree.getValue());
            if (null != tree.getLeftchildren()) {
                preVist(tree.getLeftchildren());
            }
            if (null != tree.getRightchildre()) {
                preVist(tree.getRightchildre());
            }
        }
    }

    // DBGEACHFI
    private void midVist(TreeNode tree) {
        if (null != tree) {
            if (null != tree.getLeftchildren()) {
                midVist(tree.getLeftchildren());
            }
            System.out.print(tree.getValue());
            if (null != tree.getRightchildre()) {
                midVist(tree.getRightchildre());
            }
        }
    }

    // DGEBHIFCA
    private void postVist(TreeNode tree) {
        if (null != tree) {
            if (null != tree.getLeftchildren()) {
                postVist(tree.getLeftchildren());
            }
            if (null != tree.getRightchildre()) {
                postVist(tree.getRightchildre());
            }
            System.out.print(tree.getValue());
        }
    }


    /**
     * ------------------A35
     * ------------B17--------*------C39
     * -------D9----------E28--*---------F65
     * ---------------G1-----*------H2-------I66
     */
    private TreeNode createTree() {
        TreeNode nodeG = new TreeNode("G1", null, null);
        TreeNode nodeH = new TreeNode("H2", null, null);
        TreeNode nodeI = new TreeNode("I66", null, null);
        TreeNode nodeD = new TreeNode("D9", null, null);
        TreeNode nodeE = new TreeNode("E28", nodeG, null);
        TreeNode nodeF = new TreeNode("F65", nodeH, nodeI);
        TreeNode nodeB = new TreeNode("B17", nodeD, nodeE);
        TreeNode nodeC = new TreeNode("C39", null, nodeF);
        TreeNode nodeA = new TreeNode("A35", nodeB, nodeC);
        return nodeA;
    }
}