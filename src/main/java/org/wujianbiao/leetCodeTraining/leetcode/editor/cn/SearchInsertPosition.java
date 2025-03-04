package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
//
// 输入: nums = [1,3,5,6], target = 5
// 输出: 2
//
//
// 示例 2:
//
//
// 输入: nums = [1,3,5,6], target = 2
// 输出: 1
//
//
// 示例 3:
//
//
// 输入: nums = [1,3,5,6], target = 7
// 输出: 4
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 为 无重复元素 的 升序 排列数组
// -10⁴ <= target <= 10⁴
//
//
// Related Topics 数组 二分查找 👍 2239 👎 0



public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 实际上是二分查找，如果找不到对应 target 时，根据边界值返回对应的 index
         * 
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }

            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int midValue = nums[mid];
                if (midValue == target) {
                    return mid;
                }

                if (midValue > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // 走到这，说明数组中没有 target 值。
            if (left > nums.length - 1) {
                return nums.length;
            }

            return left;


            // 如果执行到这一步，说明数组中没有 target 值。
            // 此时的核心是以单边为基准，比如以 right 指针的位置为主，会有如下几种情况：
            // 1. target 比数组中所有的数字都小，此时 right 已经左移到了 -1 位。
            // 2. target 比数组中所有的数字都大，此时 right 已经移动到了数组的末尾，left 已经超过 right 到了nums.length
            // 3. target 有值，直接返回，这是最常规的二分。
            // 4. target 在数组的中间某一个位置插入，while 循环结束的时候，right 在 left 的左边，插入的位置既是 right 的下一位。可以画图看一下几种情况。
            // return right + 1;

            // 如果以 left 为准，也可以穷举一下返回情况。
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
