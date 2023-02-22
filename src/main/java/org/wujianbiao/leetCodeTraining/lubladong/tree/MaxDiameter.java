package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc 最大直径
 *      *         100
 *      *           \
 *      *            1
 *      *           / \
 *      *          2   3
 *      *         / \   \
 *      *        4   5   6
 *      *               /
 *      *              7
 *       TreeUtils#getTree2() 的最大【直径】是5，4->2->1->3->6->7
 * @Author wujianbiao
 * @CreateTime 2023/2/22 3:01 PM
 **/
public class MaxDiameter {

    private int maxDiameter;


    // 解题思路：最大直径=左子树的最大直径+右子树的最大直径


    /**
     * 递归计算所有子树的最大直径
     * 时间复杂度 O(n2)，getMaxDepth 中又一次递归了当前节点的所有子树
     * @param root
     */
    private void count(TreeNode root) {
        if (root==null){
            return;
        }

        int leftDepth=getMaxDepth(root.left);
        int rightDepth=getMaxDepth(root.right);

        int eachDiameter=leftDepth+rightDepth;
        maxDiameter=Math.max(maxDiameter, eachDiameter);

        count(root.left);
        count(root.right);
    }

    /**
     * TODO 没有彻底搞懂，再看看
     * @param root
     * @return
     */
    private int count2(TreeNode root) {
        if (root==null){
            return 0;
        }

        int leftDepth=getMaxDepth(root.left);
        int rightDepth=getMaxDepth(root.right);

        int eachDiameter=leftDepth+rightDepth;
        maxDiameter=Math.max(maxDiameter, eachDiameter);

        return Math.max(leftDepth, rightDepth)+1;
    }

    /**
     * 深度优先，递归求子树的深度
     * 最大深度=每一个子树的深度之和
     *
     * @param root
     * @return
     */
    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result;

        int leftMax = getMaxDepth(root.left);
        int rightMax = getMaxDepth(root.right);
        result = Math.max(leftMax, rightMax) + 1;


        return result;
    }


    public static void main(String[] args) {
        MaxDiameter maxDiameter=new MaxDiameter();
        TreeNode tree=TreeUtils.getTree2();

        maxDiameter.count2(tree);

        System.out.println(maxDiameter.maxDiameter);
    }
}
