package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
// 输入：s = "()"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：s = "()[]{}"
// 输出：true
//
//
// 示例 3：
//
//
// 输入：s = "(]"
// 输出：false
//
//
// 示例 4：
//
//
// 输入：s = "([)]"
// 输出：false
//
//
// 示例 5：
//
//
// 输入：s = "{[]}"
// 输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2374 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) {
                return false;
            }

            Map<Character, Character> mapUse = new HashMap<Character, Character>();
            mapUse.put('(', ')');
            mapUse.put('{', '}');
            mapUse.put('[', ']');

            if (s.length() > 0 && !mapUse.containsKey(s.charAt(0))) {
                return false;
            }

            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                if (mapUse.containsKey(s.charAt(i))) {
                    stack.add(s.charAt(i));
                } else {
                    if (s.charAt(i) != stack.getLast()) {
                        return false;
                    }
                }
            }

            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
