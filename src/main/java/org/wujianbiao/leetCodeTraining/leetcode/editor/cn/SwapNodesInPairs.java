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
            // ListNode pre = new ListNode(-1);
            // pre.next = head;
            // ListNode cur = pre;
            // // 两个节点为一组最小的执行单元。如果当前节点为 null，或只剩一个节点时，则不需要再反转
            // while (cur.next != null && cur.next.next != null) {
            // ListNode start = cur.next;
            // ListNode end = cur.next.next;
            //
            // // 在每一次执行单元中，交换 start 和 end
            // start.next = end.next;
            // end.next = start;
            // cur.next = end;
            //
            // // 交换完 start 和 end 之后，不要忘记将 cur 指到 start 上。这里一定要画个图示意一下，其实 start 就是每一个执行单元的最后一个节点。
            // // 这个节点进入下一轮 while 循环，cur.next 和 cur.next.next 就是新一轮的 start 和 end
            // cur = start;
            // }
            //
            // // 交换过程中 pre 虚拟指针一直没变，始终指向头节点，因此直接返回即可。
            // return pre.next;

            if (head == null || head.next == null) {
                return head;
            }

            ListNode end = head.next;
            // 递归的参数是 next.next，因为两个节点是一个反转的最小单元
            // 每一个最小的递归单元中，head 等价于 start 节点，next 等价于 end 节点，end 需要反转为指向 start，
            // 核心：start 需要指向的是下一个递归单元反转之后的第一个节点，也就是 end。所以需要使用 temp 来接收递归的返回值，使得 head 指向下一环的第一个节点。
            ListNode temp = swapPairs2(end.next);

            end.next = head;
            head.next = temp;

            return end;
        }

        /**
         * 递归实现
         * 终止条件：当前节点为空 或 下一个节点为空
         * 最小单元内的操作：【start，end】节点的指向进行反转，end 指向 start，start 指向下一个单元的【起点】
         * 返回值：反转之后的最小单元的【起点】
         * 
         * @param start
         * @return
         */
        public ListNode swapPairs2(ListNode start) {
            if (start == null || start.next == null) {
                return start;
            }

            ListNode end = start.next;
            // 递归的参数是 next.next，因为两个节点是一个反转的最小单元
            // 每一个最小的递归单元中，head 等价于 start 节点，next 等价于 end 节点，end 需要反转为指向 start，
            // 核心：start 需要指向的是下一个递归单元反转之后的第一个节点，也就是 end。所以需要使用 temp 来接收递归的返回值，使得 head 指向下一环的第一个节点。
            ListNode temp = swapPairs2(end.next);

            end.next = start;
            start.next = temp;

            return end;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
