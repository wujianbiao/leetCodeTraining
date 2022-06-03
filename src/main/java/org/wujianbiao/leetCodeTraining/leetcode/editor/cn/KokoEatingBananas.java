package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
// 这一小时内不会再吃更多的香蕉。
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
//
//
//
//
//
//
// 示例 1：
//
//
// 输入：piles = [3,6,7,11], h = 8
// 输出：4
//
//
// 示例 2：
//
//
// 输入：piles = [30,11,23,4,20], h = 5
// 输出：30
//
//
// 示例 3：
//
//
// 输入：piles = [30,11,23,4,20], h = 6
// 输出：23
//
//
//
//
// 提示：
//
//
// 1 <= piles.length <= 104
// piles.length <= h <= 109
// 1 <= piles[i] <= 109
//
// Related Topics 数组 二分查找
// 👍 305 👎 0



public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            // left 和 right 是速度的边界值
            int left = 1;
            int right = 1000000000;

            while (left <= right) {
                int mid = (left + right) / 2;
                // 将总时长不断逼近 target，求最小速度=求左区间。所以相等时收缩右区间
                if (getHour(piles, mid) == h) {
                    right = mid - 1;
                } else if (getHour(piles, mid) < h) {
                    // 速度小于 h，则可以吃慢一点，则收缩右区间
                    right = mid - 1;
                } else {
                    // 速度大于 h，则需要吃快一点，则扩张左区间
                    left = mid + 1;
                }
            }

            return left;
        }

        // k=速度，即每小时吃掉的香蕉数量。以此获得吃完所有香蕉的总时长。
        private int getHour(int[] piles, int k) {
            int hour = 0;
            for (int i = 0; i < piles.length; i++) {
                hour += piles[i] / k;
                if (piles[i] % k != 0) {
                    hour++;
                }
            }

            return hour;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
