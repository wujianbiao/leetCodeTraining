package org.wujianbiao.codingFun.sort;

/**
 * @Desc 快速排序
 * @Author wujianbiao
 * @CreateTime 2024/5/5 9:34 PM
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quick(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



    private static void quick(int[] arr, int left, int right) {
        int t;
        int i = left;
        int j = right;
        // 为什么会有这一步
        if (left > right) {
            return;
        }

        int temp = arr[left];

        while (i < j) {
            // 从右往左，找到第一个比基础元素小的数
            while (i < j && arr[j] >= temp) {
                j--;
            }

            // 从左往右，找到第一个比基础元素大的数
            while (i < j && arr[i] <= temp) {
                i++;
            }

            // 说明 i 和 j 未相遇，则符合交换条件
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        // 走到这说明 i 和 j 相遇了，说明 j 之后再也没有比基础元素小的数，i 之前再也没有比基础元素大的数
        // 此时将基础元素和 i 交换位置，交换后的数组就一基础元素为中心完成了分割。
        arr[left] = arr[i];
        arr[i] = temp;

        // 然后递归处理左区间和右区间
        quick(arr, left, j - 1);
        quick(arr, j + 1, right);

    }
}
