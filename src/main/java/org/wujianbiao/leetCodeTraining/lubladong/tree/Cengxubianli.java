package org.wujianbiao.leetCodeTraining.lubladong.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cengxubianli {

    List<Integer> cxbl(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                continue;
            }
            result.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return result;
    }

    void cxbl2(TreeNode root) {
        if (root == null) {
            return;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 默认第一层开始
        int depth=1;
        while (!queue.isEmpty()) {
            // 循环的长度size一定要在之前就拿到，for循环开始后队列的size是实时变化的
            int size=queue.size();
            // 每一个 for 循环其实就是一个完整的层
            for (int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                System.out.println("当前处于第"+depth+"层，当前元素为"+cur.val);
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
            }

            // 每一轮 for 循环结束，代表一层完整的循环完，层数+1
            depth++;
        }

    }

    public static void main(String[] args) {
        Cengxubianli cengxubianli = new Cengxubianli();
        TreeNode tree = TreeUtils.getTree();
//        List<Integer> result = cengxubianli.cxbl(tree);
//        System.out.println(result);

        cengxubianli.cxbl2(tree);
    }
}
