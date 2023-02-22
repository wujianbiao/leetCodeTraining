package org.wujianbiao.leetCodeTraining.lubladong.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc
 *            1
 *           / \
 *          2   3
 *         / \   \
 *        4   5   6
 *               /
 *              7
 *
 * @Author wujianbiao
 * @CreateTime 2022/6/11 下午10:24
 **/
public class TreeUtils {

    /**
     * 构造一个树
     *            1
     *           / \
     *          2   3
     *         / \   \
     *        4   5   6
     *               /
     *              7
     *
     *
     * @return
     */
    public static TreeNode getTree() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        // 1--> 2，3
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        // 2--> 4，5
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        // 3--> null，6
        treeNode3.right = treeNode6;

        // 6-->7，null
        treeNode6.left = treeNode7;

        return treeNode1;
    }


    /**
     * 构造一个树，最大【直径】是5，4->2->1->3->6->7
     *         100
     *           \
     *            1
     *           / \
     *          2   3
     *         / \   \
     *        4   5   6
     *               /
     *              7
     *
     *
     * @return
     */
    public static TreeNode getTree2() {
        TreeNode treeNode100=new TreeNode(100);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode100.right=treeNode1;

        // 1--> 2，3
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        // 2--> 4，5
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        // 3--> null，6
        treeNode3.right = treeNode6;

        // 6-->7，null
        treeNode6.left = treeNode7;

        return treeNode100;
    }

    /**
     * 层序遍历并打印树，用作校验
     * @param root
     */
    public static void printEachLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode currentNext=current.next;
            Object currentNextVal=currentNext==null?null:currentNext.val;

            System.out.println("当前节点是："+current.val+" 对应的 next 指向："+ currentNextVal);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                TreeNode node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }
}
