package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 某套连招动作记作仅由小写字母组成的序列 arr，其中 arr[i] 第 i 个招式的名字。请返回第一个只出现一次的招式名称，如不存在请返回空格。
//
//
//
// 示例 1：
//
//
// 输入：arr = "abbccdeff"
// 输出：'a'
//
//
// 示例 2：
//
//
// 输入：arr = "ccdd"
// 输出：' '
//
//
//
//
// 限制：
//
// 0 <= arr.length <= 50000
//
// Related Topics 队列 哈希表 字符串 计数 👍 361 👎 0


import java.util.LinkedHashMap;
import java.util.Map;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char dismantlingAction(String arr) {
            if (arr.length() == 0) {
                return ' ';
            }

            if (arr.length() == 1) {
                return arr.charAt(0);
            }

            char result = ' ';
            //
            // LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            // for (int i = 0; i < arr.length(); i++) {
            // Integer num = map.getOrDefault(arr.charAt(i), 0);
            // map.put(arr.charAt(i), num + 1);
            // }
            //
            // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            // if (entry.getValue() <= 1) {
            // return entry.getKey();
            // }
            // }

            // 使用数组，注意题目中说的是小写字母，小写字母最多为 26 个，且和 a 相减之后可以作为数组下标，对应 0-25。
            int[] list = new int[26];
            char[] arrList = arr.toCharArray();
            for (int i = 0; i < arrList.length; i++) {
                list[arrList[i] - 'a']++;
            }

            for (char c : arrList) {
                if (list[c - 'a'] == 1) {
                    return c;
                }
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
