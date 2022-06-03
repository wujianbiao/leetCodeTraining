package org.wujianbiao.leetCodeTraining.lubladong;

import java.util.NoSuchElementException;

/**
 * @Desc 单链表实现 linkedList
 *       链表下标从 0 开始
 * @Author wujianbiao
 * @CreateTime 2022/5/25 下午3:42
 **/
public class MyLinkedList2<E> {

    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    /**
     * 头哨兵节点
     * final 修饰不可变
     */
    private final Node<E> head;

    /**
     * 尾哨兵节点
     * final 修饰不可变
     */
    private final Node<E> tail;

    private int size;

    public MyLinkedList2() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);

        head.next = tail;
        tail.next = null;

        this.size = 0;

    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 返回链表中第 index 个元素
     * 需要确保传递进来的参数是合法的
     * 
     * @param index
     * @return
     */
    private Node<E> getNode(int index) {
        Node<E> p = head.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p;
    }

    public void addFirst(E val) {
        Node<E> x = new Node(val);
        Node<E> temp = head.next;

        x.next = temp;
        head.next = x;

        size++;
    }

    public void addLast(E val) {
        // 单链表无法直接找到最后一个元素，需要遍历
        Node<E> x = new Node<>(val);

        Node<E> currentLast;
        if (size - 1 >= 0) {

            currentLast = getNode(size - 1);
        } else {
            currentLast = head;
        }

        x.next = tail;
        currentLast.next = x;

        size++;
    }

    public void add(int index, E val) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(val);
            return;
        }

        // 必须得判断index==size，当index=size 的时候其实是在最后插入，所以 getNode（size）是拿不到的，或者说拿到的是后面的哨兵节点。
        if (index == size) {
            addLast(val);
            return;
        }

        Node<E> x = new Node<>(val);

        Node<E> p = getNode(index - 1);
        Node<E> q = getNode(index);
        // 注意不能使用 getNode(index-1),index可能为 0
        x.next = q;
        p.next = x;

        size++;
    }

    public E removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }


        Node<E> currentFirst = head.next;
        Node<E> temp = currentFirst.next;

        head.next = temp;
        currentFirst.next = null;

        size--;

        return currentFirst.val;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> currentLast = getNode(size - 1);
        Node<E> currentLastPre;
        if (size - 2 >= 0) {

            currentLastPre = getNode(size - 2);
        } else {
            currentLastPre = head;
        }
        currentLastPre.next = tail;
        currentLast.next = null;


        size--;
        return currentLast.val;
    }

    public E remove(int index) {
        checkElementIndex(index);

        Node<E> current = getNode(index);
        Node<E> currentPre;
        if (index - 1 >= 0) {

            currentPre = getNode(index - 1);
        } else {
            currentPre = head;
        }

        currentPre.next = current.next;
        current.next = null;

        size--;
        return current.val;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return head.next.val;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return getNode(size - 1).val;
    }

    public E get(int index) {
        checkElementIndex(index);

        Node<E> current = getNode(index);

        return current.val;
    }

    public E set(int index, E val) {
        checkElementIndex(index);
        Node<E> current = getNode(index);
        E result = current.val;

        current.val = val;
        return result;
    }

}
