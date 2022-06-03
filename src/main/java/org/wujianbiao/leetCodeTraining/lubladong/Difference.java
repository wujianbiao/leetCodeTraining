package org.wujianbiao.leetCodeTraining.lubladong;

/**
 * @Desc 差分数组
 *       适用场景：对数组中的某一段区间频繁进行加减操作，然后问最终的数组会是什么样子。
 * @Author wujianbiao
 * @CreateTime 2022/6/1 下午4:06
 **/
public class Difference {

    private int[] diff;

    // 构建差分数组，当前位减去上一位
    private Difference(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        diff = new int[nums.length];

        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 通过差分数组，将原始数组复原
    private int[] getResult() {
        int[] result = new int[diff.length];
        result[0] = diff[0];

        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }

        return result;
    }

    /**
     * 给闭区间 [i, j] 增加 val（可以是负数）
     * 如果 end+1 已经跑到数组的最后，则说明从 start 开始到结束的所有数据都需要加上 value。
     * 否则 end+1 位之后要把 value 再减回去
     * 
     * @param start
     * @param end
     * @param value
     */
    private void increment(int start, int end, int value) {
        diff[start] += value;
        if (end + 1 < diff.length) {
            diff[end] -= value;
        }
    }

    /**
     * leetCode 370 题
     * 
     * @param length
     * @param nums
     * @return
     */
    private int[] rangeSum(int length, int[][] nums) {
        // 初始化原数组
        int[] result = new int[length];

        // 构造差分数组
        Difference df = new Difference(result);

        for (int[] s : nums) {
            df.increment(s[0], s[1], s[2]);
        }

        return df.getResult();

    }

    /**
     * leetCode 1109 题
     * 
     * @param booking
     * @param n
     * @return
     */
    private int[] air1109(int[][] booking, int n) {
        int[] nums = new int[n];
        Difference df = new Difference(nums);
        for (int[] book : booking) {
            int i = book[0] - 1;
            int j = book[1] - 1;
            int value = book[2];
            df.increment(i, j, value);
        }

        return df.getResult();
    }


    public static void main(String[] args) {
        int[] testInt = new int[] {2, 8, 6, 1};
        Difference difference = new Difference(testInt);
        int[] result = difference.getResult();

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
