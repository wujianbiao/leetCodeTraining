package org.wujianbiao.leetCodeTraining.lubladong;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/9 下午8:33
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int windowLen = 0;
        int resultLen = 0;

        // 维护一个哈希表，
        Map<Character, Integer> charMap = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);

            // 哈希表某个 key 的 value>1 则说明出现了重复
            while (charMap.get(c) > 1) {
                // 左移窗口，将哈希表中的数量减少
                char leftChar = s.charAt(left);
                charMap.put(leftChar, charMap.getOrDefault(leftChar, 0) - 1);
                left++;
            }

            windowLen = right - left + 1;
            resultLen = Math.max(windowLen, resultLen);
            right++;
        }


        return resultLen;
    }
}
