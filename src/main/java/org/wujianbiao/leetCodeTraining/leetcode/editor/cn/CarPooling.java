package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
//
//
//
// 示例 1：
//
//
// 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
// 输出：false
//
//
// 示例 2：
//
//
// 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
// 输出：true
//
//
//
//
// 提示：
//
//
// 1 <= trips.length <= 1000
// trips[i].length == 3
// 1 <= numPassengersi <= 100
// 0 <= fromi < toi <= 1000
// 1 <= capacity <= 105
//
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列）
// 👍 177 👎 0


/**
 * 差分数组，在乘客上车的位置和下车的位置之间，加上乘客数量，下车之后减去。
 * 最终得到的数组，每一个元素不能大于最大载客量，即可。
 */
public class CarPooling {
    public static void main(String[] args) {
        Solution solution = new CarPooling().new Solution();
        int[][] nums = {{7, 5, 6}, {6, 7, 8}, {10, 1, 6}};
        System.out.println(solution.carPooling(nums, 16));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] nums = new int[1000];
            int[] diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < diff.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }

            // 差分数组加和
            for (int[] trip : trips) {
                int start = trip[1];
                int end = trip[2] - 1;
                int value = trip[0];
                diff[start] += value;
                if (end + 1 < diff.length) {
                    diff[end+1] -= value;
                }
            }

            // 返回改动之后的数组
            int[] result = new int[diff.length];
            result[0] = diff[0];
            for (int i = 1; i < result.length; i++) {
                result[i] = diff[i] + result[i - 1];
            }

            for (int i = 0; i < result.length; i++) {
                if (result[i] > capacity) {
                    return false;
                }
            }

            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
