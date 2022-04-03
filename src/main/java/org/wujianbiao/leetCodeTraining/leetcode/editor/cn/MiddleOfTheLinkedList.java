package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//
// 如果有两个中间结点，则返回第二个中间结点。
//
//
//
// 示例 1：
//
//
// 输入：[1,2,3,4,5]
// 输出：此列表中的结点 3 (序列化形式：[3,4,5])
// 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
// 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
// ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next =
// NULL.
//
//
// 示例 2：
//
//
// 输入：[1,2,3,4,5,6]
// 输出：此列表中的结点 4 (序列化形式：[4,5,6])
// 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
//
//
//
//
// 提示：
//
//
// 给定链表的结点数介于 1 和 100 之间。
//
// Related Topics 链表
// 👍 321 👎 0


/**
 * 返回单链表的中间节点
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode listNode = ListNode.buildNodeList();
        Solution2 solution = new MiddleOfTheLinkedList().new Solution2();
        System.out.println(solution.middleNode(listNode));

    }


    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            // 1： 放置一个数组，利用数组下标有序的特点直接返回。遍历一次，时间复杂度O(n)，空间复杂度O（n）
            ListNode[] nodeList = new ListNode[100];
            ListNode current = head;
            int cun = 0;
            while (current != null) {
                nodeList[cun] = current;
                current = current.next;
                cun++;
                System.out.println(cun);
            }

            return nodeList[cun / 2];
        }
    }

    /**
     * // 2：不创建新的数组，用一个指针，先顺序遍历一次，记录下来总的节点个数 num 。再从尾到头遍历，直到 num/2 处
     */
    class Solution2 {
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode current = head;
            int num = 0;
            while (current != null) {
                num++;
                current = current.next;
            }

            current = head;
            int cun = 0;
            while (cun != (num / 2)) {
                current = current.next;
                cun++;
            }

            return current;
        }
    }

    /**
     * 3：快慢指针法。慢指针一次前进 1 位，快指针一次前进 2 位，这样当快指针遍历到列表最后的时候，慢指针刚好在链表的中间节点。
     * 同理，快慢指针的这个特性，还能够用来找出单链表的1/3、1/4等，只需要修改快慢指针之间的查值即可。
     * 快慢指针还能用来判断链表上是否有环，如果有环的话，快慢指针会相遇
     */
    class Solution3 {
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
        }
    }

}
