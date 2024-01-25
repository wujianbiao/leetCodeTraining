package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4,5], n = 2
// 输出：[1,2,3,5]
//
//
// 示例 2：
//
//
// 输入：head = [1], n = 1
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：head = [1,2], n = 1
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1327 👎 0



public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 1.遍历两次，第一次获取链表的长度，第二次直接删除。
            // 2.压栈，弹出到 n 个时候直接抛弃
            // 3.快慢指针，快指针先走 n 个，然后快慢指针同时开始走，直到快指针走到头。注意：慢指针是放 head 呢，还是放 head 前一位呢？画图就知道了
            if (head == null) {
                return head;
            }

            ListNode pre = new ListNode(0);
            pre.next = head;

            ListNode fast = pre;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }

            ListNode slow = pre;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            // 此时 fast 已经走到最后一个节点，slow 正好在第 n-1 个节点
            slow.next = slow.next.next;

            return pre.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
