package org.wujianbiao.leetCodeTraining.lubladong.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/2/22 6:51 PM
 **/
public class ConnectEachLevel {

    /**
     * 使用层序遍历，层序遍历的for 循环每次遍历一层的所有节点，只需要在最后一个节点之前进行连接即可
     * 
     * @param root
     */
    private void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            int size = queue.size();

            // 核心，for 循环迭代的刚好就是每一层，不会跨越到下一层中
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();

                if (i < size - 1) {
                    temp.next = queue.peek();
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }

            }
        }

    }

    public static void main(String[] args) {
        ConnectEachLevel connectEachLevel = new ConnectEachLevel();
        TreeNode tree = TreeUtils.getTree2();

        connectEachLevel.connect(tree);
        TreeUtils.printEachLevel(tree);
    }
}

