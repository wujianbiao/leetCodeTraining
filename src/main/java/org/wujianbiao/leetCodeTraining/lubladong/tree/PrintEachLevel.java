package org.wujianbiao.leetCodeTraining.lubladong.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc 层序遍历
 *       按照层的顺序依次将左右子节点押入队列，按押入顺序弹出
 * @Author wujianbiao
 * @CreateTime 2023/2/22 4:49 PM
 **/
public class PrintEachLevel {

    private void printEachLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.println(tempNode.val);

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.getTree2();
        PrintEachLevel printEachLevel = new PrintEachLevel();
        printEachLevel.printEachLevel(tree);

    }
}
