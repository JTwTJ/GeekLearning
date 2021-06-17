package Sword_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/6/17
 * @detail 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 * <p>
 * <p>
 * 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution63 {

    //双重for循环
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int earn = prices[j] - prices[i];
                if (earn <= 0) {
                    continue;
                }
                if (earn > max) {
                    max = earn;
                }
            }
        }
        return max;
    }

    //动态递归二维数组dp table （该方法leetcode 内存超出限制）
    public int maxProfitDP(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][len];
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int earn = prices[j] - prices[i];
                if (earn <= 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                } else {
                    dp[i][j] = max(dp[i][j - 1], dp[i + 1][j], earn);
                }
            }
        }
        return dp[0][len - 1];
    }

    //一维dp 注意思想很巧妙
    public int maxProfitDP1(int[] prices) {

        int len = prices.length;
        //定义dp profit：前i天最大利润，cost：前i天最大花费
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }

    private int max(int var1, int var2, int var3) {
        return Math.max(Math.max(var1, var2), var3);
    }

    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        int i = solution63.maxProfitDP(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
