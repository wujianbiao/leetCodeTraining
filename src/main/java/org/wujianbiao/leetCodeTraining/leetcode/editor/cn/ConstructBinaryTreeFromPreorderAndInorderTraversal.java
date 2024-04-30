package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
// 返回其根节点。
//
//
//
// 示例 1:
//
//
// 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// 输出: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
// 输入: preorder = [-1], inorder = [-1]
// 输出: [-1]
//
//
//
//
// 提示:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均 无重复 元素
// inorder 均出现在 preorder
// preorder 保证 为二叉树的前序遍历序列
// inorder 保证 为二叉树的中序遍历序列
//
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2291 👎 0


import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

        // 将 indexMap 和 preorderIndex 放到类变量中，降低递归方法的入参个数
        Map<Integer, Integer> indexMap;
        int preorderIndex;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            indexMap = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }

            // 画个图看一下，能发现如下规律：
            // 前序数组从前往后遍历，值是按照最左原则排列的，会顺着二叉树的左侧一直到最左的节点。
            // 后序数组从后往前遍历，值是按照最右原则排列的，会顺着二叉树的右侧一直到最右的节点。
            // 所以，这里从前序数组的 0 位置开始遍历，递归方法中也先处理左子树。
            this.preorderIndex = 0;

            return helper(preorder, inorder, 0, inorder.length - 1);
        }

        /**
         * 递归处理子树
         * 
         * @param preorder
         * @param inorder
         * @param inStart
         * @param inEnd
         * @return
         */
        private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
            if (inStart > inEnd) {
                return null;
            }

            int rootValue = preorder[preorderIndex];
            TreeNode rootNode = new TreeNode(rootValue);

            preorderIndex++;

            int inorderdex = indexMap.get(rootValue);

            // 注意下方递归方法的顺序，前序遍历一定是先处理 左子树。
            // 如果是后序遍历，则先处理 右子树。
            rootNode.left = helper(preorder, inorder, inStart, inorderdex - 1);
            rootNode.right = helper(preorder, inorder, inorderdex + 1, inEnd);
            return rootNode;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
