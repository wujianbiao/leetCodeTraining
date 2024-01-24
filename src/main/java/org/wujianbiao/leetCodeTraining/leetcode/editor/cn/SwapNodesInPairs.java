package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4]
// 输出：[2,1,4,3]
//
//
// 示例 2：
//
//
// 输入：head = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：head = [1]
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
// Related Topics 递归 链表 👍 2132 👎 0



public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // 迭代
            // 虚拟头节点
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode cur = pre;
            // 两个节点为一组最小的执行单元。如果当前节点为 null，或只剩一个节点时，则不需要再反转
            while (cur.next != null && cur.next.next != null) {
                ListNode start = cur.next;
                ListNode end = cur.next.next;

                // 在每一次执行单元中，交换 start 和 end
                start.next = end.next;
                end.next = start;
                cur.next = end;

                // 交换完 start 和 end 之后，不要忘记将 cur 指到 start 上。这里一定要画个图示意一下，其实 start 就是每一个执行单元的最后一个节点。
                // 这个节点进入下一轮 while 循环，cur.next 和 cur.next.next 就是新一轮的 start 和 end
                cur = start;
            }

            // 交换过程中 pre 虚拟指针一直没变，始终指向头节点，因此直接返回即可。
            return pre.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
