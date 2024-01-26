package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,3,4,4,5]
// 输出：[1,2,5]
//
//
// 示例 2：
//
//
// 输入：head = [1,1,1,2,3]
// 输出：[2,3]
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
// Related Topics 链表 双指针 👍 1266 👎 0


public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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
            // 官方题解
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(-999);
            dummy.next = head;
            ListNode cur = dummy;

            // 每次判断 cur 后的两个指针，如果两个值不相等，则将 cur 前进一位。
            // 如果两个值相等，重点：需要记录下这个相等的值，然后从 cur 处开始while循环，只要 cur.next.value = value，就通过 cur.next = cur.next.next
            // 的方式把这个点跳过。
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    int value = cur.next.val;
                    while (cur.next != null && cur.next.val == value) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }

            return dummy.next;



            // // 排除链表为空，或者只有一个节点的情况
            // if (head == null || head.next == null) {
            // return head;
            // }
            //
            // // 需要使用三个指针。left 和 right 指针用来寻找重复元素，first 指向的是不重复的点
            // ListNode pre = new ListNode(-999);
            // pre.next = head;
            // ListNode first = pre;
            // ListNode left = first.next;
            // ListNode right = first.next.next;
            // while (true) {
            //
            // // 我的实现中是没有记录每一次重复的数值的，所以当某一个重复的值全部被找到之后并且刚好最后还剩一个节点，此时就需要针对当 right 走到末尾时特殊处理一下，将 first 指向
            // left，不然最后一个不重复节点会丢失。
            // 而官方题解中，每一次 cur.next 的指向都是发生了变化的，所以不需要担心最后一个节点被漏掉。
            // // eg.[1,2,3,3,3,4],此时 left=4，right=null
            // if (right == null) {
            // first.next = left;
            // break;
            // }
            //
            // // 如果连续的两个节点的值不相同，则第一个遇到的节点一定是不重复的。第二个节点不一定，它有可能和之后的节点重复。
            // if (left.val != right.val) {
            // first.next = left;
            // first = first.next;
            // left = left.next;
            // right = right.next;
            // continue;
            // }
            //
            // // 找到连续的重复值
            // while (right != null && right.val == left.val) {
            // right = right.next;
            // }
            //
            // // 将 left 和 right 区间的所有节点全部清楚，只移动 left 指针，不操作 first 指针。注意 right 可能会走到末尾，需要判空。
            // left = right;
            // if (right != null) {
            // right = right.next;
            // }
            // }
            //
            // return pre.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
