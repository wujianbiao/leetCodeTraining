package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,1,2]
// 输出：[1,2]
//
//
// 示例 2：
//
//
// 输入：head = [1,1,2,3,3]
// 输出：[1,2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//
//
// Related Topics 链表 👍 1103 👎 0



public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = new ListNode(-999);
            pre.next = head;
            ListNode left = pre;
            ListNode right = head;
            while (left != null && right != null) {
                if (right.val == left.val) {
                    while (right != null && right.val == left.val) {
                        right = right.next;
                    }

                    // 跳过所有的重复项，当 while 循环结束的时候 right 在第一个与之前不重复的节点处
                    left.next = right;
                }
                left = left.next;
                if (right != null) {
                    right = right.next;
                }
            }

            return pre.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
