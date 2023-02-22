package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc 寻找二叉树的最大深度
 *       深度：根节点到叶子节点的最长路径的节点数量，其实也是层数，如 TreeUtils 中的深度就是 4
 * @Author wujianbiao
 * @CreateTime 2022/6/11 下午10:02
 **/
public class MaxDepth {
    private int weight = 0;
    private int result = 0;


    /**
     * 深度优先，递归求子树的深度
     * 最大深度=每一个子树的深度之和
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
     * 进入节点时，weight 深度加一，离开节点时，weight 深度减一
     * 
     * @param root
     * @return
     */
    private int getMaxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        weight++;
        // 如果当前节点没有左右子节点，则为叶子节点，到达叶子节点时更新最大深度。
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

        System.out.println(maxDepth.getMaxDepth(tree));
        System.out.println(maxDepth.getMaxDepth2(tree));

    }
}

