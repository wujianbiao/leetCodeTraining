package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
// 一个节点也可以是它自己的祖先）。”
//
//
//
// 示例 1：
//
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// 输出：3
// 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//
//
// 示例 2：
//
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// 输出：5
// 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//
//
// 示例 3：
//
//
// 输入：root = [1,2], p = 1, q = 2
// 输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 10⁵] 内。
// -10⁹ <= Node.val <= 10⁹
// 所有 Node.val 互不相同 。
// p != q
// p 和 q 均存在于给定的二叉树中。
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 2680 👎 0



public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // 核心思路：如果一个节点的左子树存在 p 或 q，并且右子树存在 p 或 q，此时这个节点就是目标节点。此外，需要注意是【最近】一个公共
            // 祖先，根节点一定是公共祖先，在左子树或者右子树找到 p 或者 q 的时候，需要把对应节点带回去。
            // 因此，需要按照后序遍历的方式，通过左右孩子的结果来判断根节点的结果。

            // 递归三要素：函数返回值、终止条件、单层递归逻辑

            // 终止条件：遇到空节点直接返回 null，如果遇到 p 或者 q，返回对应节点
            if (root == null) {
                return null;
            }

            if (root.val == p.val || root.val == q.val) {
                return root;
            }

            // 单层逻辑，递归遍历左右子树
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 左子树和右子树都不为空，则说明在左子树和右子树找到了 p 和 q，此时根节点 root 就是公共祖先，将这个节点一路向上返回。
            if (left != null && right != null) {
                return root;
            }

            // left 不为空代表左子树找到了 p 或者 q，right 同理，如果都为 null 说明这个根节点的左右子树都没有 p 或 q。
            if (left != null && right == null) {
                return left;
            }

            if (left == null && right != null) {
                return right;
            }

            return null;

        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
