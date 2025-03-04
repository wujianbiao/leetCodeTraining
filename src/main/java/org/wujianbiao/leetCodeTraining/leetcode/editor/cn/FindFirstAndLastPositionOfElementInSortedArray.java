package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
//
// 示例 2：
//
//
// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]
//
// 示例 3：
//
//
// 输入：nums = [], target = 0
// 输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
//
// Related Topics 数组 二分查找 👍 2591 👎 0



public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 7, 7, 8, 8, 8, 9, 9, 10};
        int target = 8;
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(nums, target);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[] {-1, -1};
            }



            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int midValue = nums[mid];
                // 找到了其中一个 target ，但是
                // 可能是第一个 target，可能是最后一个，也可能是中间的一个。
                if (midValue == target) {
                    int start = mid;
                    int end = mid;
                    while (mid >= 0) {
                        mid--;
                        if (nums[mid] == target) {
                            start = mid;
                        }
                    }

                    while (mid <= right) {
                        mid++;
                        end = mid;
                    }
                    return new int[] {start, end};
                }

                if (target > midValue) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return new int[] {-1, -1};
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
