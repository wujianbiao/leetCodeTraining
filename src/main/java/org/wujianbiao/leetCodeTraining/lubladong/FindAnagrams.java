package org.wujianbiao.leetCodeTraining.lubladong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 *       给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *       异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *       来源：力扣（LeetCode）
 *       链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 *       著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author wujianbiao
 * @CreateTime 2022/6/8 下午11:03
 **/
public class FindAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";
        System.out.println(min(s, t));
    }

    private static List<Integer> min(String s, String t) {

        if (s.length() < t.length()) {
            return new ArrayList<>();
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 将需要覆盖的元素放到 need 集合中
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int validCount = 0;
        List<Integer> result = new ArrayList<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    validCount++;
                }
            }


            // 全部覆盖到了，开始缩减窗口
            while (validCount == need.size()) {
                if (right - left + 1 == t.length()) {
                    result.add(left);
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
            right++;
        }

        // 注意。subString 也是左闭右开的，所以要+1
        return result;
    }
}
