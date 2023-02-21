package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc 寻找二叉树的最大深度
 * @Author wujianbiao
 * @CreateTime 2022/6/11 下午10:02
 **/
public class MaxDepth {
    private int weight = 0;
    private int result = 0;


    /**
     * 深度优先，递归求子树的深度
     * 
     * @param root
     * @return
     */
    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result;

        int leftMax = getMaxDepth(root.left);
        int rightMax = getMaxDepth(root.right);
        result = Math.max(leftMax, rightMax) + 1;


        return result;
    }

    /**
     * 广度优先
     * 
     * @param root
     * @return
     */
    private int getMaxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        System.out.println(root.val);
        weight++;
        // 如果当前节点没有左右子节点，则为叶子节点，此时判断深度 weight 就是路径。
        if (root.left == null && root.right == null) {
            result = Math.max(result, weight);
        }

        getMaxDepth2(root.left);
        getMaxDepth2(root.right);

        weight--;
        return result;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode tree = TreeUtils.getTree();
        TreeNode testTree = new TreeNode(1);

        System.out.println(maxDepth.getMaxDepth2(testTree));

    }
}

