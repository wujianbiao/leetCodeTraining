package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
// 示例 1：
//
//
// 输入：head = [1,2,6,3,4,5,6], val = 6
// 输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
// 输入：head = [], val = 1
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：head = [7,7,7,7], val = 7
// 输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点在范围 [0, 104] 内
// 1 <= Node.val <= 50
// 0 <= k <= 50
//
// Related Topics 链表
// 👍 567 👎 0


/**
 * 移除单链表中的指定元素
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
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
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }

            // 使用哨兵节点。哨兵节点就是自定义一个不带value的节点 NodeA，NodeA.next=head
            // 什么时候使用哨兵节点呢？当我们要删除的元素处于链表的头节点的时候，边界条件的判断就会变得十分复杂，这个时候使用哨兵节点的话，就可以把所有节点统一处理。

            ListNode nodeA = new ListNode(0);
            nodeA.next = head;

            ListNode current = head;
            ListNode prev = nodeA;

            while (current != null) {
                if (current.val == val) {
                    prev.next = current.next;
                } else {
                    prev = current;
                }
                current = current.next;
            }

            return nodeA.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
