package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
// 输入：root = [3,9,20,null,null,15,7]
// 输出：[[3],[9,20],[15,7]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 1922 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder2(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> result = new ArrayList<>();

            // 注意，new 的是 linkedList，是 queue 接口的一个实现类。
            Queue<TreeNode> queue = new LinkedList<>();
            int size = 0;
            queue.offer(root);

            while (!queue.isEmpty()) {
                // size 为当前队列中的元素个数，每次从队列中弹出 size 个，也就是每次弹出一层中的所有节点
                size = queue.size();
                List<Integer> eachResult = new ArrayList<>();
                while (size > 0) {
                    TreeNode cur = queue.poll();
                    eachResult.add(cur.val);
                    // 在弹出节点的过程中，将左右孩子节点加入队列，也就是下一层节点
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }

                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    // 当 size 递减到 0 的时候，说明这一层已经全部弹出了。注意这个 size 只能从外层的 while 循环中从 queue.size 取，
                    // 在新节点入队的时候不能直接++，不然会导致死循环
                    size--;
                }

                result.add(eachResult);
            }

            return result;

        }

        public List<List<Integer>> levelOrder(TreeNode treeNode) {
            if (treeNode == null) {
                return new ArrayList<>();
            }

            // 使用一个队列来接收每一层的节点。
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(treeNode);

            List<List<Integer>> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                List<Integer> each = new ArrayList<>();
                for (int i = 0; i < queueSize; i++) {
                    TreeNode current = queue.poll();
                    each.add(current.val);

                    if (current.left != null) {
                        queue.offer(current.left);
                    }

                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
                result.add(each);
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
