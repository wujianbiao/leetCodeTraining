package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 返回容器可以储存的最大水量。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
// 输入：[1,8,6,2,5,4,8,3,7]
// 输出：49
// 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
// 输入：height = [1,1]
// 输出：1
//
//
//
//
// 提示：
//
//
// n == height.length
// 2 <= n <= 10⁵
// 0 <= height[i] <= 10⁴
//
//
// Related Topics 贪心 数组 双指针 👍 4754 👎 0



public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            if (height.length < 2) {
                return 0;
            }

            int result = 0;

            // 1.先用暴力法，O(N2)的时间复杂度，会超时
            // for (int i = 0; i < height.length - 1; i++) {
            // for (int j = i + 1; j < height.length; j++) {
            // int item = Math.min(height[i], height[j]) * (j - i);
            // result = Math.max(result, item);
            // }
            // }

            // 2.双指针，矩形的底边为 j-i,高为对应值更小的那个。
            // 每次移动指针的时候，无论移动那一边，底边都会变小，为了找到更大值，只能尝试让高变大，所以移动更小的那一个指针。本质是贪心的策略。
            int i = 0;
            int j = height.length - 1;
            while (i < j) {
                int item = Math.min(height[i], height[j]) * (j - i);
                result = Math.max(result, item);
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
            }


            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
