package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;


import org.wujianbiao.leetCodeTraining.leetcode.editor.cn.utils.ListNodeUtils;


// 合并两个有序链表
public class MergeTwoSortedLists {
    public static void main(String[] args) {

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(20);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = null;


        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(17);
        ListNode node25 = new ListNode(18);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = null;


        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNodeUtils.printListNode(solution.mergeTwoLists(node11, node21));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }

            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }


            ListNode response = new ListNode();
            ListNode head = response;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }

                head = head.next;
            }

            if (l1 == null) {
                head.next = l2;
            } else {
                head.next = l1;
            }

            return response.next;
        }
    }
}
