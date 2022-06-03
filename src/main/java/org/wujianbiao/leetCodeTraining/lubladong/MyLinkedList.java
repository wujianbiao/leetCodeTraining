package org.wujianbiao.leetCodeTraining.lubladong;

import java.util.NoSuchElementException;

/**
 * @Desc 双指针实现 linkedList
 * @Author wujianbiao
 * @CreateTime 2022/5/25 下午3:42
 **/
public class MyLinkedList<E> {

    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

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

    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);

        head.next = tail;
        tail.prev = head;

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

        x.prev = head;
        x.next = temp;
        head.next = x;
        temp.prev = x;

        size++;
    }

    public void addLast(E val) {
        Node<E> x = new Node<>(val);
        Node<E> temp = tail.prev;

        x.next = tail;
        x.prev = temp;

        temp.next = x;
        tail.prev = x;

        size++;
    }

    public void add(int index, E val) {
        checkPositionIndex(index);

        // 可以不用判断 index=0，因为前面还有一个哨兵节点，所有不用担心第 0 个元素的前一个节点为 null 的问题！秒！
        // if (index == 0) {
        // addFirst(val);
        // return;
        // }

        // 必须得判断index==size，当index=size 的时候其实是在最后插入，所以 getNode（size）是拿不到的，或者说拿到的是后面的哨兵节点。
        if (index == size) {
            addLast(val);
            return;
        }

        Node<E> x = new Node<>(val);

        Node<E> p = getNode(index);
        // 注意不能使用 getNode(index-1),index可能为 0
        Node<E> temps = p.prev;

        x.next = p;
        x.prev = temps;
        temps.next = x;
        p.prev = x;

        size++;
    }

    public E removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }


        Node<E> currentFirst = head.next;
        Node<E> temp = currentFirst.next;

        head.next = temp;
        temp.prev = head;

        currentFirst.prev = null;
        currentFirst.next = null;

        size--;

        return currentFirst.val;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> currentLast = tail.prev;
        Node<E> temp = currentLast.prev;

        temp.next = tail;
        tail.prev = temp;

        currentLast.prev = null;
        currentLast.next = null;


        size--;
        return currentLast.val;
    }

    public E remove(int index) {
        checkElementIndex(index);

        Node<E> current = getNode(index);

        Node<E> currentPre = current.prev;
        Node<E> currentNext = current.next;

        currentPre.next = currentNext;
        currentNext.prev = currentPre;

        current.next = null;
        current.prev = null;

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

        return tail.prev.val;
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
