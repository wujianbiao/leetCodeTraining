package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,2,2,3,4,4,3]
// 输出：true
//
//
// 示例 2：
//
//
// 输入：root = [1,2,2,null,3,null,3]
// 输出：false
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 1000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2700 👎 0


import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode root2Left = new TreeNode(2);
        TreeNode root2Right = new TreeNode(2);
        TreeNode root3Left = new TreeNode(3);
        TreeNode root4Left = new TreeNode(4);
        TreeNode root4Right = new TreeNode(4);
        TreeNode root3Right = new TreeNode(3);

        root.left = root2Left;
        root.right = root2Right;
        root2Left.left = root3Left;
        root2Left.right = root4Left;

        root2Right.left = root4Right;
        root2Right.right = root3Right;

        solution.isSymmetric(root);



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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return false;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();
                    TreeNode next = queue.poll();
                    // 如果两个孩子节点都是 null 也是对称的
                    if (current == null && next == null) {
                        continue;
                    }

                    if (current == null || next == null || current.val != next.val) {
                        return false;
                    }

                    // 重点：因为要判断对称性，所以需要按照对称的顺序加入到队列中，左孩子的左节点对应右孩子的右节点。
                    queue.offer(current.left);
                    queue.offer(next.right);
                    queue.offer(current.right);
                    queue.offer(next.left);
                }
            }

            return true;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
