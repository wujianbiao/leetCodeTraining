package org.wujianbiao.leetCodeTraining.lubladong;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/8 下午11:03
 **/
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(min(s, t));
    }

    private static String min(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 将需要覆盖的元素放到 need 集合中
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int startIndex = 0;
        int validCount = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    validCount++;
                }
            }


            // 全部覆盖到了，开始缩减窗口
            while (validCount == need.size()) {
                // 判断最优解
                if (right - left < len) {
                    len = right - left;
                    startIndex = left;
                }

                char d = s.charAt(left);
                if (need.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d) < need.get(d)) {
                        validCount--;
                    }
                }

                left++;
            }
        }

        // 注意。subString 也是左闭右开的，所以要+1
        return len < Integer.MAX_VALUE ? s.substring(startIndex, startIndex + len) : "";
    }
}
