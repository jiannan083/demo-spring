package cn.bfay.datastructure;

import java.util.LinkedList;
import org.junit.Test;

/**
 * TreeTest.
 *
 * @author wangjiannan
 * @since 2020/12/10
 */
public class TreeTest1 {
    @Test
    public void testVist() {
        TreeNode tree = createTree();
        System.out.print("前序遍历:");
        preorderVistTreeNode(tree);
        System.out.println("");

        System.out.print("中序遍历:");
        inorderVistTreeNode(tree);
        System.out.println("");

        System.out.print("后序遍历:");
        postorderVistTreeNode(tree);
        System.out.println("");

        System.out.print("层次遍历:");
        levelorderVistTreeNode(tree);
        System.out.println();
    }

    // 深度优先（DFS）Depth First Search

    /**
     * 前序遍历
     * 思路：先根节点->左子树->右子树；
     */
    private void preorderVistTreeNode(TreeNode node) {
        if (null != node) {

            System.out.print(node.value);

            if (null != node.leftchildren) {
                preorderVistTreeNode(node.leftchildren);
            }
            if (null != node.rightchildre) {
                preorderVistTreeNode(node.rightchildre);
            }
        }
    }

    /**
     * 中序遍历
     * 思路：先左子树->根节点->右子树；
     */
    private void inorderVistTreeNode(TreeNode node) {
        if (null != node) {
            if (null != node.leftchildren) {
                inorderVistTreeNode(node.leftchildren);
            }

            System.out.print(node.value);

            if (null != node.rightchildre) {
                inorderVistTreeNode(node.rightchildre);
            }
        }
    }

    /**
     * 后序遍历
     * 思路：先左子树->右子树->根节点；
     */
    private void postorderVistTreeNode(TreeNode node) {
        if (null != node) {
            if (null != node.leftchildren) {
                postorderVistTreeNode(node.leftchildren);
            }
            if (null != node.rightchildre) {
                postorderVistTreeNode(node.rightchildre);
            }

            System.out.print(node.value);

        }
    }

    // 广度优先（BFS）Breadth First Search

    /**
     * 层次遍历
     * 思路：先根节点，然后第二层，第三层，依次往下走，（同层节点从左往右输出）;
     * 层序遍历二叉树，是非递归的队列实现的，就是利用队列的先进先出（FIFO）实现的。
     */
    public void levelorderVistTreeNode(TreeNode node) {
        if (null != node) {
            LinkedList<TreeNode> list = new LinkedList<TreeNode>();
            list.add(node);
            TreeNode currentNode;

            while (!list.isEmpty()) {
                currentNode = list.poll(); //获取并移除此列表的头

                System.out.print(currentNode.value);

                if (null != currentNode.leftchildren) {
                    list.add(currentNode.leftchildren);
                }
                if (null != currentNode.rightchildre) {
                    list.add(currentNode.rightchildre);
                }
            }
        }
    }

    /**
     * ------------------A
     * ------------B--------*------C
     * -------D----------E--*---------F
     * ---------------G-----*------H-------I
     */
    private TreeNode createTree() {
        // Map<String, String> map = new HashMap<>();
        // map.put("dd", "qq");
        // 叶子节点
        TreeNode G = new TreeNode("G");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E", G, null);
        TreeNode B = new TreeNode("B", D, E);
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode F = new TreeNode("F", H, I);
        TreeNode C = new TreeNode("C", null, F);
        // 构造根节点
        TreeNode root = new TreeNode("A", B, C);
        return root;
    }
}