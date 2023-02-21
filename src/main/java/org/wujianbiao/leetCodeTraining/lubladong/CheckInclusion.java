package org.wujianbiao.leetCodeTraining.lubladong;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/9 下午9:26
 **/
public class CheckInclusion {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        // 构造 s1 的词频哈希表
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int validNum = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < s2.length()) {
            char str = s2.charAt(right);
            if (needs.containsKey(str)) {
                window.put(str, window.getOrDefault(str, 0) + 1);
                if (window.getOrDefault(str, 0).equals(needs.get(str))) {
                    validNum++;
                }
            }

            // 窗口中包含了 s2 中的所有字符，开始缩减左指针，判断是否含有排列
            while (right - left + 1 >= s1.length()) {
                if (validNum == needs.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                if (needs.containsKey(d)) {
                    window.put(d, window.getOrDefault(d, 0) - 1);
                    if (window.get(d) < needs.get(d)) {
                        validNum--;
                    }
                }

                left++;
            }

            right++;
        }

        return false;
    }
}
