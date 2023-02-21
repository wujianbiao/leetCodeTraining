package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc 二叉树的基础节点
 * @Author wujianbiao
 * @CreateTime 2022/6/11 下午10:03
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
