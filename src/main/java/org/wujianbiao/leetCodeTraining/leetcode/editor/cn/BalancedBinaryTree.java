package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个二叉树，判断它是否是 平衡二叉树
//
//
//
// 示例 1：
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：root = [1,2,2,3,3,null,null,4,4]
// 输出：false
//
//
// 示例 3：
//
//
// 输入：root = []
// 输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -10⁴ <= Node.val <= 10⁴
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 1503 👎 0



public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        /**
         * 获取当前节点的树的高度，注意是高度，因此整体的框架是后序遍历。
         * 
         * @param root
         * @return 如果当前节点对应的左右子树高度差大于 1 ，则返回 -1 ，说明已经不平衡了不需要再判断其他的。否则，返回当前节点的高度。
         */
        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = getHeight(root.left);
            if (leftHeight == -1) {
                return -1;
            }

            int rightHeight = getHeight(root.right);
            if (rightHeight == -1) {
                return -1;
            }

            int result;
            if (Math.abs(leftHeight - rightHeight) > 1) {
                result = -1;
            } else {
                result = 1 + Math.max(leftHeight, rightHeight);
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
