package org.wujianbiao.leetCodeTraining.leetcode.editor.cn.utils;

import org.wujianbiao.leetCodeTraining.leetcode.editor.cn.ListNode;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2021/3/27 3:53 下午
 **/
public class ListNodeUtils {

    public static void printListNode(ListNode headNode) {
        while (headNode != null) {
            System.out.println(headNode.getVal());
            headNode = headNode.getNext();
        }
    }
}
