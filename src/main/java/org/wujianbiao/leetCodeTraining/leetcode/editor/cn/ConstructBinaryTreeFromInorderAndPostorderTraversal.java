package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
// 返回这颗 二叉树 。
//
//
//
// 示例 1:
//
//
// 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// 输出：[3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
// 输入：inorder = [-1], postorder = [-1]
// 输出：[-1]
//
//
//
//
// 提示:
//
//
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder 和 postorder 都由 不同 的值组成
// postorder 中每一个值都在 inorder 中
// inorder 保证是树的中序遍历
// postorder 保证是树的后序遍历
//
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1218 👎 0


import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = new int[] {8, 4, 9, 2, 5, 10, 1, 11, 6, 3, 12, 7, 13};
        int[] postorder = new int[] {8, 9, 4, 10, 5, 2, 11, 6, 12, 13, 7, 3, 1};
        solution.buildTree(inorder, postorder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        int postIndex;
        int[] inorder;
        int[] postorder;
        Map<Integer, Integer> valueIndexMap;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 1. 后续遍历为 左->右->根，所以 postorder 的最后一位元素肯定是根节点
            // 2. 根据上一步找到的根节点，在 inorder 数组中找到对应的元素位置 i，i 的左边则为左子树，i 的右侧则为右子树。
            valueIndexMap = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                valueIndexMap.put(inorder[i], i);
            }

            postIndex = postorder.length - 1;
            this.inorder = inorder;
            this.postorder = postorder;

            return transvert(0, inorder.length - 1);
        }

        private TreeNode transvert(int inStart, int inEnd) {
            if (inStart > inEnd) {
                return null;
            }

            System.out.println("当前 postIndex 是：" + postIndex + "当前中序数组的 start 是" + inStart + " end 是：" + inEnd);
            int rootValue = postorder[postIndex];
            TreeNode rootNode = new TreeNode(rootValue);

            // 获取当前根节点在中序数组中的下标位置，此位置的左边就是左子树，右边就是右子树。
            int inorderIndex = valueIndexMap.get(rootValue);

            // 当前元素已经被使用，后序数组中的下标递减
            postIndex--;

            // 构造右子树
            rootNode.right = transvert(inorderIndex + 1, inEnd);
            System.out.println("当前节点是：" + rootValue + "，右孩子是：" + rootNode.right);
            // 构造左子树
            rootNode.left = transvert(inStart, inorderIndex - 1);
            System.out.println("当前节点是：" + rootValue + "，左孩子是：" + rootNode.left);

            return rootNode;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
