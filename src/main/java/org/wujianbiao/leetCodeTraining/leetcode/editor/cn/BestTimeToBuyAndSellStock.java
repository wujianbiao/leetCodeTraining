package org.wujianbiao.leetCodeTraining.leetcode.editor.cn;

// 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//
//
// 示例 1：
//
//
// 输入：[7,1,5,3,6,4]
// 输出：5
// 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
// 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2：
//
//
// 输入：prices = [7,6,4,3,1]
// 输出：0
// 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 10⁵
// 0 <= prices[i] <= 10⁴
//
//
// Related Topics 数组 动态规划 👍 3440 👎 0


/**
 * 数组只能正向遍历，不能倒退，你不能在今天买入然后在昨天卖出
 * 在往后的一段时间内，找到最低价买入，才能再卖出的时候获得最大收益。
 * 但是，这个最低价指的是【一段时间内】，并不一定是整个数组范围内的。波段。
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        solution.maxProfit(prices);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int maxProfit(int[] prices) {
            int maxMoney = 0;// 最大利润
            int slowIndex = 0;// 慢指针
            int fastIndex = 1;// 快指针
            int lastIndex = prices.length - 1;// 最后索引
            while (fastIndex <= lastIndex) {
                int money = prices[fastIndex] - prices[slowIndex];
                if (money > maxMoney) {
                    maxMoney = money;
                }
                // 如果 money<0，意味着 fast 的价格更低，因此将 slow 更新到更低的价格上。
                if (money < 0) {
                    slowIndex = fastIndex;
                }
                fastIndex++;
            }
            return maxMoney;
        }

    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0 || prices.length == 1) {
                return 0;
            }

            int result = 0;
            int cost = Integer.MAX_VALUE;
            // 数组只遍历一次，且不能后退
            for (int price : prices) {
                // 记录最小成本
                cost = Math.min(cost, price);
                // 记录最大收益。注意，期间最小成本可能会变化，也就是找到更小的，但是最大收益不一定会变化。
                result = Math.max(price - cost, result);
            }

            return result;
        }

    }

    // leetcode submit region end(Prohibit modification and deletion)

}
