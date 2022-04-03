package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

import lombok.Data;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2021/3/27 3:50 下午
 **/
@Data
public class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildNodeList() {
        // 1.构建一个单链表

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        return node1;
    }
}

