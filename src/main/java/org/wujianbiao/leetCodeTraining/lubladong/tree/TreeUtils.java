package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc
 *            1
 *           / \
 *          2   3
 *         / \   \
 *        4   5   6
 *               /
 *              7
 *
 * @Author wujianbiao
 * @CreateTime 2022/6/11 下午10:24
 **/
public class TreeUtils {

    /**
     * 构造一个树
     * 
     * @return
     */
    public static TreeNode getTree() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        // 1--> 2，3
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        // 2--> 4，5
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        // 3--> null，6
        treeNode3.right = treeNode6;

        // 6-->7，null
        treeNode6.left = treeNode7;

        return treeNode1;
    }
}
