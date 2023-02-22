package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/2/21 8:16 PM
 **/
public class TreeIterator2 {

    private void pre(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println("前序遍历当前节点为：" + node.val);
        pre(node.left);
        pre(node.right);
    }

    private void mid(TreeNode node) {
        if (node == null) {
            return;
        }

        mid(node.left);
        System.out.println("中序遍历当前节点为：" + node.val);
        mid(node.right);
    }

    private void after(TreeNode node) {
        if (node == null) {
            return;
        }

        after(node.left);
        after(node.right);
        System.out.println("后序遍历当前节点为：" + node.val);
    }

    /**
     * 打印出每个节点的左右子树各有多少节点
     *
     * @param root
     */
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);

        System.out.println("节点 " + root.val + " 的左子树有" + leftCount + " 个节点，右子树有 " + rightCount + " 个节点");
        return leftCount + rightCount + 1;
    }

    /**
     * 如果把根节点看做第 1 层，如何打印出每一个节点所在的层数
     * 
     * @param root
     */
    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        String str = String.format("当前节点为：%d，处于第 %d 层", root.val, level);
        System.out.println(str);

        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeIterator2 treeIterator2 = new TreeIterator2();

        TreeNode tree = TreeUtils.getTree();

        treeIterator2.pre(tree);
        System.out.println("--------------分割线--------------");
        treeIterator2.mid(tree);

        System.out.println("--------------分割线--------------");
        treeIterator2.after(tree);

        System.out.println("--------------分割线--------------");
        treeIterator2.count(tree);

        System.out.println("--------------分割线--------------");
        treeIterator2.traverse(tree, 1);

    }
}
