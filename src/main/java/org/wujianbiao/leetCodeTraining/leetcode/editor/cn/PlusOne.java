package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
// 输入：digits = [1,2,3]
// 输出：[1,2,4]
// 解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
// 输入：digits = [4,3,2,1]
// 输出：[4,3,2,2]
// 解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
// 输入：digits = [0]
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
//
// Related Topics 数组 数学 👍 1355 👎 0



public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            // 从数组的末尾开始向前遍历
            // 1 需要记录进位信息
            // 2 如果+1之后使得数字的长度+1了，此时还需要移动数组
            // 3 整数越界的问题
            int plus = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int pre = digits[i];
                int cur = pre + plus;
                plus = 0;
                if (cur >= 10) {
                    cur = cur % 10;
                    plus = 1;
                }
                digits[i] = cur;
                if (plus == 0) {
                    break;
                }

                // 需要进位
                if (i == 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    for (int j = 1; j < result.length; j++) {
                        result[j] = digits[j - 1];
                    }
                    return result;
                }
            }

            return digits;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
