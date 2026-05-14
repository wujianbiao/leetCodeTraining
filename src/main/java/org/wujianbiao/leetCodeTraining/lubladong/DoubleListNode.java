package org.wujianbiao.leetCodeTraining.lubladong;

import java.util.PriorityQueue;

public class DoubleListNode {
    private int val;
    private DoubleListNode pre;
    private DoubleListNode next;

    private DoubleListNode(int vale) {
        this.val = vale;
    }

    public static DoubleListNode createDoubleLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        DoubleListNode head = new DoubleListNode(arr[0]);
        DoubleListNode cur = head;

        for (int i = 0; i < arr.length; i++) {
            DoubleListNode newNode = new DoubleListNode(arr[i]);
            cur.next = newNode;
            newNode.pre = cur;
            cur = cur.next;
        }

        return head;
    }


    public static void main(String[] args) {
        DoubleListNode head = createDoubleLinkedList(new int[]{1, 2, 3, 4, 5});
        DoubleListNode cur = head;

        //把元素 66 插入到索引 3（第 4 个节点）的位置
        //要注意这个2是怎么得来的，画画图别干想
        for (int i = 0; i < 2; i++) {
            cur = cur.next;
        }

        // cur 当前就是第三个节点
        DoubleListNode newNode = new DoubleListNode(66);
        newNode.next = cur.next;
        newNode.pre = cur;

        cur.next.pre=newNode;
        cur.next = newNode;
    }
}
