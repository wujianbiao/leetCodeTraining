package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定二叉树的根节点 root ，返回所有左叶子之和。
//
//
//
// 示例 1：
//
//
//
//
// 输入: root = [3,9,20,null,null,15,7]
// 输出: 24
// 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// 示例 2:
//
//
// 输入: root = [1]
// 输出: 0
//
//
//
//
// 提示:
//
//
// 节点数在 [1, 1000] 范围内
// -1000 <= Node.val <= 1000
//
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 708 👎 0


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // 递归实现
            // int leftValue = sumOfLeftLeaves(root.left);
            // int rightValue = sumOfLeftLeaves(root.right);
            //
            // int currentValue = 0;
            // if (root.left != null && root.left.left == null && root.left.right == null) {
            // currentValue = root.left.val;
            // }
            //
            // return leftValue + rightValue + currentValue;

            // 迭代实现--前序遍历
            // Stack<TreeNode> stack = new Stack<>();
            // stack.push(root);
            //
            // int result = 0;
            //
            // while (!stack.isEmpty()) {
            //
            // TreeNode current = stack.pop();
            // if (current.left != null) {
            // stack.push(current.left);
            // if (current.left.left == null && current.left.right == null) {
            // result += current.left.val;
            // }
            // }
            //
            // if (current.right != null) {
            // stack.push(current.right);
            // }
            //
            // }
            //
            // return result;


            // 迭代实现--层顺遍历
            int result = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();

                    if (current.left != null) {
                        queue.offer(current.left);
                        if (current.left.left == null && current.left.right == null) {
                            result += current.left.val;
                        }
                    }

                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
