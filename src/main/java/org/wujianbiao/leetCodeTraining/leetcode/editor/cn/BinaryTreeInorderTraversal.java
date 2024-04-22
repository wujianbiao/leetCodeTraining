package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,null,2,3]
// 输出：[1,3,2]
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
// 示例 4：
//
//
// 输入：root = [1,2]
// 输出：[2,1]
//
//
// 示例 5：
//
//
// 输入：root = [1,null,2]
// 输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 938 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<>();

            // 递归
            // preorder(root, result);

            // 迭代遍历
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            // 当 root!=null 时说明还没有遍历到叶子节点
            while (cur != null || !stack.isEmpty()) {
                // 一直往左找到左子树的最底下一个节点
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    // cur=null 时找到了叶子节点，此时开始处理栈中的元素
                    // 每弹出一个元素后都会重新走一遍 while 的逻辑，当弹出的为 叶子节点时，cur.right==null
                    // 因此在下一轮 while 的时候还会继续走到这个 else 的弹出逻辑中。
                    // 当cur.right!=null 时，下一轮 while 循环会开始处理右子树。整体的处理逻辑就是左根右。
                    cur = stack.pop();
                    result.add(cur.val);
                    cur = cur.right;
                }
            }

            return result;
        }


        /**
         * 中序遍历：左根右
         * 递归
         * 
         * @param node
         * @param result
         */
        private void preorder(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }

            preorder(node.left, result);
            result.add(node.val);
            preorder(node.right, result);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
