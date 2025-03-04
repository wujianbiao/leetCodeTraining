package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 某套连招动作记作序列 arr，其中 arr[i] 为第 i 个招式的名字。请返回 arr 中最多可以出连续不重复的多少个招式。
//
//
//
// 示例 1:
//
//
// 输入: arr = "dbascDdad"
// 输出: 6
// 解释: 因为连续且最长的招式序列是 "dbascD" 或 "bascDd"，所以其长度为 6。
//
//
// 示例 2:
//
//
// 输入: arr = "KKK"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "K"，所以其长度为 1。
//
//
// 示例 3:
//
//
// 输入: arr = "pwwkew"
// 输出: 3
// 解释: 因为连续且最长的招式序列是 "wke"，所以其长度为 3。 
// 请注意区分 子串 与 子序列 的概念：你的答案必须是 连续招式 的长度，也就是 子串。而 "pwke" 是一个非连续的 子序列，不是 子串。
//
//
//
//
// 提示：
//
//
// 0 <= arr.length <= 40000
// arr 由英文字母、数字、符号和空格组成。
//
//
//
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
// repeating-characters/
//
//
//
// Related Topics 哈希表 字符串 滑动窗口 👍 627 👎 0


import java.util.HashMap;
import java.util.Map;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dismantlingAction(String arr) {
            if (arr.length() == 0) {
                return 0;
            }

            if (arr.length() == 1) {
                return 1;
            }

            int result = 0;

            int left = 0;
            HashMap<Character, Integer> charIndexMap = new HashMap<>();
            for (int right = 0; right < arr.length(); right++) {
                // 遇到重复字符，更新左区间，更新字符的最大下标
                if (charIndexMap.containsKey(arr.charAt(right))) {
                    left = Math.max(left, charIndexMap.get(arr.charAt(right)) + 1);
                }

                charIndexMap.put(arr.charAt(right), right);
                result = Math.max(result, right - left + 1);
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
