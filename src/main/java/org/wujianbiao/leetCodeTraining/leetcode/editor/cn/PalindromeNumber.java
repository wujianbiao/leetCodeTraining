package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;



public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(-121));
    }

    class Solution {
        public boolean isPalindrome(int x) {
            int y = 0;
            int result = x;
            while (x != 0) {
                y = x % 10 + y * 10;
                x /= 10;
            }

            System.out.println(y);
            System.out.println(result);

            return result == y;
        }
    }

}

