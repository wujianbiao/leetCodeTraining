package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc 反转单链表
 * @Author wujianbiao
 * @CreateTime 2021/3/25 11:15 下午
 **/
public class NodeLearning {

    public static void main(String[] args) {
        NodeInfo headNode = buildNodeList();
        printNode(headNode);

        NodeInfo newHead;
        // 1.非递归反转单链表
        // newHead= reverse(headNode);

        // 2.递归反转单链表
        // newHead = reverseStack(headNode);

        // 3.反转前 N 个节点
        // newHead = reversePreN(headNode, 3);

        // 4.反转后 N 个节点
        // newHead = reverseLastN(headNode, 3);

        newHead = reverseFromM2N(headNode, 3, 4);
        printNode(newHead);
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

    /**
     * 递归反转单链表
     * 
     * @param head
     * @return
     */
    private static NodeInfo reverseStack(NodeInfo head) {
        if (head == null || head.next == null) {
            return head;
        }

        NodeInfo last = reverseStack(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    /**
     * 反转前N个节点
     * 
     * @param head
     * @param n
     * @return
     */
    private static NodeInfo reversePreN(NodeInfo head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        // 找到第 N+1 个节点
        NodeInfo nNext = head;
        for (int i = 0; i < n; i++) {
            nNext = nNext.next;
        }

        NodeInfo pre = null;
        NodeInfo cur = head;
        NodeInfo next;
        // 第 1 到第 N+1 个节点之间就按照套路反转即可。
        while (cur != nNext) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 将一直未动的头节点挂到第 N+1 个节点处，此时 cur 也跑到了 nNext 处。此处 head.next=nNext 也可以。
        head.next = cur;

        return pre;
    }

    /**
     * 反转后 N 个节点
     * 
     * @param head
     * @param n
     * @return
     */
    private static NodeInfo reverseLastN(NodeInfo head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        // 利用快慢指针定位需要反转的起始节点
        NodeInfo slow = head;
        NodeInfo fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 此时 slow.next 和 fast 之间就是需要反转的节点

        NodeInfo pre = null;
        NodeInfo cur = slow.next;
        NodeInfo next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        slow.next = pre;

        return head;
    }

    /**
     * 反转第 M 到 N 个节点
     * 
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static NodeInfo reverseFromM2N(NodeInfo head, int m, int n) {
        NodeInfo preStart = head;
        if (m == 1) {
            preStart = head;
        } else {
            for (int i = 0; i < m - 2; i++) {
                preStart = preStart.next;
            }
        }

        NodeInfo nNext = head;
        for (int i = 0; i < n; i++) {
            nNext = nNext.next;
        }

        // preStart+1 到 nNext-1 之间就是需要反转的节点
        NodeInfo pre = null;
        NodeInfo cur = preStart.next;
        NodeInfo next;

        while (cur != nNext) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        preStart.next.next = nNext;
        preStart.next = pre;

        return head;
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

    public static NodeInfo buildNodeList() {
        // 1.构建一个单链表

        NodeInfo node1 = new NodeInfo(1);
        NodeInfo node2 = new NodeInfo(2);
        NodeInfo node3 = new NodeInfo(3);
        NodeInfo node4 = new NodeInfo(4);
        NodeInfo node5 = new NodeInfo(5);
        NodeInfo node6 = new NodeInfo(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        return node1;
    }

    public static void printNode(NodeInfo headNode) {
        System.out.println(headNode);
        while (headNode != null) {
            System.out.println(headNode.getValue());
            headNode = headNode.next;
        }
    }

}
