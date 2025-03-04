package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
//
//
//
//
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4,5]
// 输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
// 输入：head = [1,2]
// 输出：[2,1]
//
//
// 示例 3：
//
//
// 输入：head = []
// 输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
//
//
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/
//
// Related Topics 递归 链表 👍 195 👎 0


import java.util.Stack;

public class UHnkqh {
    public static void main(String[] args) {
        Solution solution = new UHnkqh().new Solution();

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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            Stack<ListNode> stack = new Stack<ListNode>();
            while (head.next != null) {
                stack.push(head);
                head = head.next;
            }

            ListNode newHead = new ListNode(-1);
            ListNode current = newHead;
            while (!stack.isEmpty()) {
                ListNode newOne = stack.pop();
                current.next = newOne;
                current = current.next;
            }

            return newHead.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
