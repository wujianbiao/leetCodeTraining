package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[3,2,1]
//
//
// 示例 2：
//
//
// 输入：root = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：root = [1]
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1166 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<>();
            // 递归
            // digui(result, root);


            // 后序遍历：左右根。
            // 在前序遍历的基础上，将出栈顺序改为 根右左，最终再将 result 数组进行反转，直接获得 左右根。
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) {
                    continue;
                } else {
                    result.add(node.val);
                }

                stack.push(node.left);
                stack.push(node.right);
            }

            Collections.reverse(result);
            return result;
        }

        private void digui(List<Integer> result, TreeNode node) {
            if (node == null) {
                return;
            }

            digui(result, node.left);
            digui(result, node.right);
            result.add(node.val);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
