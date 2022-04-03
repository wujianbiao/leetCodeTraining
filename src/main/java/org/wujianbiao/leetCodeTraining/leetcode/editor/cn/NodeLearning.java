package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc 反转单链表
 * @Author wujianbiao
 * @CreateTime 2021/3/25 11:15 下午
 **/
public class NodeLearning {
    private static NodeInfo buildNodeList() {
        // 1.构建一个单链表

        NodeInfo node1 = new NodeInfo(1);
        NodeInfo node2 = new NodeInfo(2);
        NodeInfo node3 = new NodeInfo(3);
        NodeInfo node4 = new NodeInfo(4);
        NodeInfo node5 = new NodeInfo(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        return node1;
    }

    /**
     * 反转单链表
     * 
     * @param head
     * @return
     */
    private static NodeInfo reverse(NodeInfo head) {
        // 空节点或者单个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        NodeInfo current = head;
        NodeInfo pre = null;
        NodeInfo next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;

        }

        return pre;
    }

    private static void printNode(NodeInfo headNode) {
        System.out.println(headNode);
        while (headNode != null) {
            System.out.println(headNode.getValue());
            headNode = headNode.next;
        }
    }


    public static void main(String[] args) {
        NodeInfo headNode = buildNodeList();
        printNode(headNode);
        NodeInfo headAfterReverse = reverse(headNode);
        printNode(headAfterReverse);
    }



    @Data
    @NoArgsConstructor
    static class NodeInfo {

        private int value;

        private NodeInfo next;

        NodeInfo(int value) {
            this.value = value;
        }
    }

}
