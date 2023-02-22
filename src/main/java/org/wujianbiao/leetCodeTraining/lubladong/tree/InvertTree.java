package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/2/22 5:41 PM
 **/
public class InvertTree {

    /**
     * 二叉树反转--层序遍历写法
     * 常规写法，将每个节点的左右子树依次反转即可
     * 
     * @param root
     */
    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }

        // 每个节点都将它的左右子树交换。
        // 叶子节点没有子树，跳过
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    /**
     * 二叉树反转--递归写法
     * 递归将左右子树反转，返回返回后的子树节点，最终整个树也会反转，需要注意的是后续遍历。
     * 
     * @param root
     * @return
     */
    private TreeNode invertAndReturn(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertAndReturn(root.left);
        TreeNode right = invertAndReturn(root.right);

        // 叶子节点没有子树，跳过
        if (root.left == null && root.right == null) {
            return root;
        }

        root.left = right;
        root.right = left;

        return root;
    }


    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();

        TreeNode tree = TreeUtils.getTree2();
        // invertTree.invert(tree);
        invertTree.invertAndReturn(tree);

        TreeUtils.printEachLevel(tree);
    }
}
