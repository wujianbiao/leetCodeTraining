package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
// 示例 1:
//
//
// 输入: nums = [0,1,0,3,12]
// 输出: [1,3,12,0,0]
//
//
// 示例 2:
//
//
// 输入: nums = [0]
// 输出: [0]
//
//
//
// 提示:
//
//
//
// 1 <= nums.length <= 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
//
//
//
//
// 进阶：你能尽量减少完成的操作次数吗？
//
// Related Topics 数组 双指针 👍 2266 👎 0



public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 遍历数组，每当找到一个 0 之后，接着找下一个非 0 数字，然后交换。
        // public void moveZeroes(int[] nums) {
        // if (nums.length == 0) {
        // return;
        // }
        //
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] == 0) {
        // for (int j = i; j < nums.length; j++) {
        // if (nums[j] != 0) {
        // nums[i] = nums[j];
        // nums[j] = 0;
        // break;
        // }
        // }
        // }
        // }
        // }

        public void moveZeroes2(int[] nums) {
            if (nums.length == 0) {
                return;
            }

            // j 之后的全部可以赋值为 0
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    j++;
                }
            }

            for (int i = j; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        // 借鉴快速排序的思想，将非0数字换位到左边，0换位到右边
        public void moveZeroes(int[] nums) {
            if (nums.length == 0) {
                return;
            }

            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
