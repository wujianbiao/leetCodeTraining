package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/12 上午1:33
 **/
public class sss {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        System.out.println(root.val);
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序位置，顺便计算最大直径
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        sss ss = new sss();
        TreeNode tree = TreeUtils.getTree();
        System.out.println(ss.diameterOfBinaryTree(tree));
    }
}
