package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
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
// Related Topics 递归 链表 👍 3484 👎 0



public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode node = ListNode.buildNodeList();
        solution.reverseList(node);
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

            // 迭代法
            // ListNode pre = null;
            // ListNode cur = head;
            // ListNode next;
            //
            // while (cur != null) {
            // next = cur.next;
            // cur.next = pre;
            // pre = cur;
            // cur = next;
            // }
            //
            // return pre;

            // 递归
            return reverse(null, head);
        }

        /**
         * 递归方法
         *
         * @param pre
         * @param cur
         * @return
         */
        public ListNode reverse(ListNode pre, ListNode cur) {
            // 递归的终止条件，当前节点和 pre 节点为一组进行操作，当cur为 null 的时候表示已经走到了链表的终点。此时递归栈也压到了最后一位
            if (cur == null) {
                return pre;
            }

            // 程序会在这里递归的往下执行，一直到 cur.next=null，也就是上面的if判断处才会返回，此时返回的 pre 就是链表的最后一个节点。
            // 这个节点也是反转后的头节点，所以我们需要把这个结果保存下来直接返回。
            ListNode res = reverse(cur, cur.next);

            // 在每一次递归的单元中，核心的操作就是将两个单节点进行反转。递归到最后一个节点后开始回溯，回溯的时候每一个节点都会执行一遍这个逻辑，
            // 将当前节点的 next 指向 pre。
            cur.next = pre;
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
