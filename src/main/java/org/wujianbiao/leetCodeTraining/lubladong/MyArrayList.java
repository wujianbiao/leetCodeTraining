package org.wujianbiao.leetCodeTraining.lubladong;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.omg.CORBA.Object;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/5/18 下午10:36
 **/
public class MyArrayList<E> {

    private E[] dates;

    private int size;

    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCap) {
        if (initCap > 0) {
            dates = (E[]) new Object[initCap];
            size = 0;
        } else if (initCap == 0) {
            dates = (E[]) new Object[0];
            size = 0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 在 index 处插入一个
     * 
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        checkPositionIndex(index);

        // 1. 数据搬移
        System.arraycopy(dates, index, dates, index + 1, size - index);
        // 2.赋值
        dates[index] = element;
        size++;
    }

    /**
     * 在集合最后一位增加元素
     * 
     * @param element
     */
    public void addLast(E element) {
        if (dates.length == size) {
            resize(dates.length * 2);
        }

        dates[size] = element;
        size++;
    }

    public E remove(int index) {
        checkElementIndex(index);
        E result = dates[index];

        System.arraycopy(dates, index + 1, dates, index, size - index - 1);
        // 数据搬移之后，需要把空出来的最后一位删除，否则会有内存泄漏风险
        dates[size - 1] = null;
        size--;
        return result;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E result = dates[size - 1];
        // 将最后以为元素置为 null 之后，才能被正常垃圾回，不然可能造成内存泄漏。
        dates[size - 1] = null;
        size--;

        // 缩容
        if (size < dates.length / 4) {
            resize(dates.length / 2);
        }

        return result;
    }

    public E get(int index) {
        checkElementIndex(index);
        return dates[index];
    }

    /**
     * 在 index 位置插入新值，并返回旧值
     * 
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        checkElementIndex(index);
        E result = dates[index];
        dates[index] = element;
        return result;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * @param index
     * @return
     * 
     */
    private boolean isPositionIndex(int index) {
        // 关于这里为什么可以等于 size。
        // 举个例子，假设数组的 size=5，此时 index=5 则表示要加入第 6 位元素，这是可以的，大不了扩容。但是如果直接 index= 6 呢？
        // 次数数组的第 6 位还是 null 的时候就想加入第 7 位，这和数组连续内存的使用方式是不符合的。
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 将数组大小扩容或者缩容为 newCap
     * 
     * @param newCap
     */
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        System.arraycopy(dates, 0, temp, 0, size);
        new ArrayList<>();
    }


}
