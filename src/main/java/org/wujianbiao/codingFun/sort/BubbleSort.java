package org.wujianbiao.codingFun.sort;

/**
 * @Desc 冒泡排序
 * @Author wujianbiao
 * @CreateTime 2024/4/3 6:43 PM
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("原始数组：");
        printArray(array);

        bubbleSort(array);

        System.out.println("排序后的数组：");
        printArray(array);
    }

    // 冒泡排序算法
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换相邻的两个元素
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 打印数组
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
