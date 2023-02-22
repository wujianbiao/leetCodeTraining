package org.wujianbiao.leetCodeTraining.lubladong.tree;

/**
 * @Desc 二叉树的前中后序遍历
 * @Author wujianbiao
 * @CreateTime 2022/6/11 下午10:41
 **/
public class TreeIterator {

    private int level = 0;



    /**
     * 前序遍历
     * 
     * @param root
     */
    private void pre(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private void mid(TreeNode root) {
        if (root == null) {
            return;
        }

        mid(root.left);
        System.out.println(root.val);
        mid(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    private void hou(TreeNode root) {
        if (root == null) {
            return;
        }

        hou(root.left);
        hou(root.right);
        System.out.println(root.val);
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
     * 打印每一个节点所在的层数
     * ps.这个方法没有返回值，没有记录层数信息，其实添加一个外部变量，在 level++ 之后与变量对比，取大的那一个就是最大深度了。
     * @param root
     */
    private void printEachLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        level++;
        System.out.println("节点 " + root.val + " 在第 " + level + " 层");
        printEachLevel(root.left);
        printEachLevel(root.right);
        level--;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.getTree();
        TreeIterator treeIterator = new TreeIterator();
        // treeIterator.pre(tree);
        // treeIterator.mid(tree);
        // treeIterator.hou(tree);

        // treeIterator.count(tree);
        treeIterator.printEachLevel(tree);
    }
}
