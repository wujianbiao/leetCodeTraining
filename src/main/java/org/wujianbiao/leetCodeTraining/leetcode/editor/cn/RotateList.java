package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4,5], k = 2
// 输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
// 输入：head = [0,1,2], k = 4
// 输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 10⁹
//
//
// Related Topics 链表 双指针 👍 1026 👎 0



public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
        ListNode node = ListNode.buildNodeList();
        solution.rotateRight(node, 2);
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k <= 0) {
                return head;
            }
            // 先遍历链表，得出总长度 length
            // 找到 length 和 k 的关系

            int length = 0;
            ListNode nodeA = head;
            while (nodeA != null) {
                nodeA = nodeA.next;
                length++;
            }

            int diff = k % length;
            if (diff == 0) {
                return head;
            }

            ListNode pre = new ListNode();
            pre.next = head;
            ListNode fast = pre;

            for (int i = 0; i < diff; i++) {
                fast = fast.next;
            }

            ListNode slow = pre;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            // 循环结束后，fast 在尾节点，slow 在即将重连的第一段的尾节点。
            // 返回 slow.next ，将 slow 指向 null，将 fast 指向头节点

            ListNode result = slow.next;
            slow.next = null;
            fast.next = pre.next;

            return result;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
