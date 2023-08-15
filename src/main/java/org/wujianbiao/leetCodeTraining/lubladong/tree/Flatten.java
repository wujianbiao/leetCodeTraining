package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/2/24 11:43 AM
 **/
public class Flatten {

    /**
     * 这个方式是错误的
     * 这个方法最终返回的 dummy.right 才是结果，是一条新的二叉树
     * 而 tree 本身只是被遍历了，并没有被拉平。
     * 因为题目的函数签名是 void 类型，所以这种方式不适用，不过可以当作一种实现思路。
     * @param root
     */
    void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode dummy = new TreeNode(-1);
        TreeNode p = dummy;

        traverse(root, p);
    }

    void traverse(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }

        p.right = new TreeNode(root.val);
        p = p.right;

        traverse(root.left, p);
        traverse(root.right, p);
    }


    /**
     * 原地拉平
     * @param root
     */
    void flatten2(TreeNode root){
        if (root==null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left=root.left;
        TreeNode right=root.right;

        root.left=null;
        root.right=left;

        if (root.right!=null){
            left.right.right=left;
        }
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        TreeNode tree = TreeUtils.getTree2();

        flatten.flatten(tree);

        TreeUtils.printEachLevel(tree);
    }
}
