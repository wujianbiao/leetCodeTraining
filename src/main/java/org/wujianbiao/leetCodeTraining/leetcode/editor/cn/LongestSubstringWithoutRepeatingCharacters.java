package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
//
//
// 示例 1:
//
//
// 输入: s = "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10124 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import io.netty.util.internal.StringUtil;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            // 维护一个滑动窗口和一个 map，记录窗口中每一个元素出现的次数，如果超过 1 则移动左边窗口
            if (s.length() == 0) {
                return 0;
            }

            if (s.length() == 1) {
                return 1;
            }

            int result = 0;
            int left = 0;
            // 记录字符出现的最远下标，以此控制左边界的移动
            HashMap<Character, Integer> charIndexMap = new HashMap<>();
            // i 为右边界，通过i++的方式自然增长，遇到重复的字符时再移动左边界。
            for (int i = 0; i < s.length(); i++) {
                if (charIndexMap.containsKey(s.charAt(i))) {
                    // 如果遇到重复的字符，需要将左边界更新为重复字符的下一位，注意要从map中取。
                    left = Math.max(left, charIndexMap.get(s.charAt(i)) + 1);
                }

                charIndexMap.put(s.charAt(i), i);
                result = Math.max(result, i - left + 1);
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
