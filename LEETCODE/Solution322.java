import java.util.Arrays;

/**
 * @author jiangwentao
 * @date 2021/6/15
 * @detail 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution322 {

    //自底向上迭代解法
    public int coinChange(int[] coins, int amount) {
        //解题思想 分段函数思想 F(x) = (逻辑操作)x  x为变量 不同区间不同函数
        //1、确定状态（确定变量 amount）----很明显改题变量应该为amount amount变化函数也会跟着变化
        //2、定义dp数组（函数F(amount)）：要凑出金额n，至少需要dp(n)个硬币
        //3、明确 base case
        //4、明确选择
        //4-1、分段函数不同区间的求值函数
        //4-2、做选择、找出当前最优解



        //0 到 amount 长度为 amount + 1
        int[] dp = new int[amount + 1];
        //因为amount全拿coin为1的用了amount个coin所以这里初始化值的时候用amount+1
        Arrays.fill(dp, amount + 1);
        //定义base case 分段区间函数       f(amount) = 0 amount = 0
        dp[0] = 0;
        //遍历每个子问题-----------当amount为 i时求最少使用硬币数
        for (int i = 0; i < dp.length; i++) {
            //内层for在求所有子问题+1的最小值
            //遍历每个可能的选择---------------每个硬币
            for (int coin : coins) {
                //子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                //状态转移=----求当前amount下用最少的硬币数
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //递归+重叠子问题
    int memo[];
    public int coinChange1(int[] coins, int amount) {

        //添加备忘录
        memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return dp(coins, amount);
    }
    public int dp(int[] coins, int amount) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            //子问题无解则跳过 如 11  用 5->5->5
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int count = solution322.coinChange(new int[]{1, 2, 5}, 9);
        System.out.println(count);
    }
}
