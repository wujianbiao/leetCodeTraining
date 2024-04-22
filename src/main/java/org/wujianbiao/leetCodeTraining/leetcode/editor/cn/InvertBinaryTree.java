package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
// 示例 1：
//
//
//
//
// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]
//
//
// 示例 2：
//
//
//
//
// 输入：root = [2,1,3]
// 输出：[2,3,1]
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
// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1789 👎 0


import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 遍历每一层的节点，反转对应节点的左右孩子，所有节点都交换完的时候树也就反转了。
                    TreeNode current = queue.poll();

                    // 注意，即使一个孩子为 null 也需要反转，不然就会出现方向错误。
                    TreeNode temp = current.left;
                    current.left = current.right;
                    current.right = temp;
                    if (current.left != null) {
                        queue.offer(current.left);
                    }

                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }

            }

            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
