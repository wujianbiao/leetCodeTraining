package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。
//
// 示例 1：
//
//
// 输入：root = [1,2,3,null,5]
// 输出：["1->2->5","1->3"]
//
//
// 示例 2：
//
//
// 输入：root = [1]
// 输出：["1"]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 100] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1131 👎 0


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<String> result = new ArrayList<>();
            List<Integer> paths = new ArrayList<>();
            digui(root, result, paths);

            // 迭代实现
            // // stack 是常规的栈，用来保存节点信息。pathStack 则用来存储遍历到对应节点时的路径信息。
            // Stack<TreeNode> stack = new Stack<>();
            // Stack<String> pathStack = new Stack<>();
            // stack.push(root);
            // // 初始化头节点的时候不需要拼接 ->
            // pathStack.push(String.valueOf(root.val));
            //
            // while (!stack.isEmpty()) {
            // // 在弹出对应节点的时候，一定要记得把路径也弹出来，这其实就是回溯操作。
            // TreeNode treeNode = stack.pop();
            // String currentPath = pathStack.pop();
            //
            // // 遍历到叶子节点时，打印对应路径
            // if (treeNode.left == null && treeNode.right == null) {
            // result.add(currentPath);
            // }
            //
            // // 往栈中压入节点的时候也需要把路径信息拼接好，然后一并入栈。
            // if (treeNode.right != null) {
            // stack.push(treeNode.right);
            // pathStack.push(currentPath + "->" + treeNode.right.val);
            // }
            //
            // if (treeNode.left != null) {
            // stack.push(treeNode.left);
            // pathStack.push(currentPath + "->" + treeNode.left.val);
            // }
            // }


            return result;
        }


        /**
         * 递归实现
         * 
         * @param root
         * @param result
         * @param paths
         */
        private void digui(TreeNode root, List<String> result, List<Integer> paths) {
            paths.add(root.val);

            // 遇到叶子节点，添加结果
            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < paths.size() - 1; i++) {
                    sb.append(paths.get(i)).append("->");
                }

                sb.append(paths.get(paths.size() - 1));
                result.add(sb.toString());
                return;
            }

            if (root.left != null) {
                digui(root.left, result, paths);
                // 回溯，当执行到这一行的时候说明递归结束了，回退的时候需要把上一步的路径信息也回退，不然最终结果会出现其他路径中的信息。
                paths.remove(paths.size() - 1);
            }

            if (root.right != null) {
                digui(root.right, result, paths);
                // 回溯，当执行到这一行的时候说明递归结束了，回退的时候需要把上一步的路径信息也回退，不然最终结果会出现其他路径中的信息。
                paths.remove(paths.size() - 1);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
