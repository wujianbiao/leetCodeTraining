package org.wujianbiao.xiaohui.shuzu;

import lombok.Data;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2021/9/19 2:38 下午
 **/
@Data
public class ArrayLearn {

    private int[] myArray;

    /**
     * 数组中实际的元素数量
     */
    private int size;

    ArrayLearn(int capacity) {
        myArray = new int[capacity];
        this.size = 0;
    }

    public void output() {
        for (int value : myArray) {
            System.out.println(value);
        }

        System.out.println("数组元素个数：" + size);
    }

    public void insert(int index, int value) {
        if (index >= myArray.length || index < 0) {
            throw new IndexOutOfBoundsException("数组越界");
        }

        for (int i = myArray.length - 1; i > index; i--) {
            myArray[i] = myArray[i - 1];
        }

        myArray[index] = value;
        size++;
    }


    public static void main(String[] args) {
        int capacity = 10;
        ArrayLearn myArray = new ArrayLearn(capacity);
        myArray.insert(0, 3);
        myArray.insert(1, 7);
        myArray.insert(2, 9);
        myArray.insert(3, 5);
        myArray.insert(1, 6);
        myArray.insert(9, 6);
        myArray.insert(8, 8);
        // myArray.insert(10, 80);
        myArray.output();

    }


}
