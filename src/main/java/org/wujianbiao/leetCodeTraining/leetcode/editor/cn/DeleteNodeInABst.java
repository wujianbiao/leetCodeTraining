package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
// 根节点的引用。
//
// 一般来说，删除节点可分为两个步骤：
//
//
// 首先找到需要删除的节点；
// 如果找到了，删除它。
//
//
//
//
// 示例 1:
//
//
//
//
// 输入：root = [5,3,6,2,4,null,7], key = 3
// 输出：[5,4,6,2,null,null,7]
// 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
// 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
// 另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
//
//
// 示例 2:
//
//
// 输入: root = [5,3,6,2,4,null,7], key = 0
// 输出: [5,3,6,2,4,null,7]
// 解释: 二叉树不包含值为 0 的节点
//
//
// 示例 3:
//
//
// 输入: root = [], key = 0
// 输出: []
//
//
//
// 提示:
//
//
// 节点数的范围 [0, 10⁴].
// -10⁵ <= Node.val <= 10⁵
// 节点值唯一
// root 是合法的二叉搜索树
// -10⁵ <= key <= 10⁵
//
//
//
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
//
// Related Topics 树 二叉搜索树 二叉树 👍 1331 👎 0



public class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
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
        // 注意递归函数的返回值为 TreeNode，返回的节点在回溯的时候会成为其父节点的孩子
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return root;
            }

            if (root.val == key) {

                // 1：如果是叶子节点，则直接删除
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left != null && root.right == null) {
                    // 2：左子树不为空，右子树为空，直接返回左子树
                    return root.left;
                } else if (root.right != null && root.left == null) {
                    // 3：右子树不为空，左子树为空，直接返回右子树
                    return root.right;
                } else if (root.left != null && root.right != null) {
                    // 4：如果左右子树都不为空，此时需要找到仅次于当前节点的值的一个节点，第一个右孩子是大于当前节点的
                    // 然后将整个左子树挂到这个右子树的最小的一个位置
                    // 下面的while 循环会一直往左遍历，直到找到右子树中最小的一个叶子结点，这个节点也是整颗右子树中最接近左子树节点值的。
                    // 然后将整颗左子树成为该叶子结点的左孩子
                    TreeNode cur = root.right;
                    while (cur.left != null) {
                        cur = cur.left;
                    }

                    cur.left = root.left;
                    return root.right;
                }
            }

            //  递归操作，如果节点值大于key，则往左遍历
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }

            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }

            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
