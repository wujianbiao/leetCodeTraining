package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
// 因为 nums[0] + nums[1] = 2 + 7 = 9
// 所以返回 [0, 1]


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution3 solution = new TwoSum().new Solution3();
        int[] intSums = new int[] {1, 2, 3, 6, 7, 10};
        int[] result = solution.twoSum(intSums, 10);
        for (int i : result) {
            System.out.println(i);
        }
    }

    // 爆破
    // class Solution {
    // public int[] twoSum(int[] nums, int target) {
    // for (int i = 0; i < nums.length; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // if (nums[i] + nums[j] == target) {
    // return new int[] {i, j};
    // }
    // }
    // }
    //
    // return new int[];
    // }
    // }


    // 通过 hash 表来做，key=当前的数字，value=下标。当 target-i 的下标，在map中已经存在时，则表示匹配成功。
    // 思考：如何决定key是什么，value是什么？
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[] {};
            }

            int init = nums.length;
            Map<Integer, Integer> numMap = new HashMap<>(init);

            for (int i = 0; i < nums.length; i++) {
                if (!numMap.containsKey(target - nums[i])) {
                    numMap.put(nums[i], i);
                } else {
                    return new int[] {i, target - nums[i]};
                }
            }

            return new int[] {};
        }
    }


    // 换一个条件，假设现在的入参是一个由小到大排序好的数组，使用双指针来做
    // 思考：什么时候适合使用双指针呢？数组有序的时候，根据匹配的规则决定移动哪一侧的指针
    class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[] {};
            }

            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int result = nums[i] + nums[j];
                if (result < target) {
                    // 加少了
                    i++;
                } else if (result > target) {
                    // 加多了
                    j--;
                } else {
                    return new int[] {i, j};
                }
            }

            return new int[] {};
        }
    }

}
