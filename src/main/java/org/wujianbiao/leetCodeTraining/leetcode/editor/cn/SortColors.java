package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//
//
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,0,2,1,1,0]
// 输出：[0,0,1,1,2,2]
//
//
// 示例 2：
//
//
// 输入：nums = [2,0,1]
// 输出：[0,1,2]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2
//
//
//
//
// 进阶：
//
//
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
//
// Related Topics 数组 双指针 排序 👍 1722 👎 0



public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            if (nums.length == 0) {
                return;
            }

            // TODO 这个方法是错误的，部分元素的排序不完全
            // 双指针，左指针对应的元素一定比右指针对应的元素小。当左右指针相遇时，排序完成。
            // 当左指针元素比右指针元素大，交换，右指针--
            // 当左指针元素比右指针元素小，左指针++
            // 当左指针元素等于右指针元素，右指针--
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] >= nums[right]) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;

                    right--;
                } else if (nums[left] < nums[right]) {
                    left++;
                    if (nums[left] > nums[left - 1]) {
                        int temp = nums[left];
                        nums[left] = nums[left - 1];
                        nums[left - 1] = temp;
                    }
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
