package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
//
//
// 示例 1：
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[[15,7],[9,20],[3]]
//
//
// 示例 2：
//
//
// 输入：root = [1]
// 输出：[[1]]
//
//
// 示例 3：
//
//
// 输入：root = []
// 输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 广度优先搜索 二叉树 👍 788 👎 0


import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        solution.levelOrderBottom(root);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();
            // 层序遍历
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // while 循环的条件只需要判断 queue 不为空，不需要判断当前节点。如果判断当前节点会导致死循环，因为在清空每一层的节点后并不会
            // 将当前节点设置为 null。
            while (!queue.isEmpty()) {
                int eachSize = queue.size();
                List<Integer> eachResult = new ArrayList<>(eachSize);
                while (eachSize > 0) {
                    TreeNode cur = queue.poll();
                    eachResult.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    eachSize--;
                }
                result.add(eachResult);
            }

            Collections.reverse(result);
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
