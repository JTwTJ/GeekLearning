/**
 * @author jiangwentao
 * @date 2021/5/19
 * @detail 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 示例 1:
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * <p>
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * <p>
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// todo
public class Solution4 {

    int count = 0;

    public int change(int amount, int[] coins) {
        if(amount == 0) {
            return 0;
        }
        dfs(amount, coins);
        return count;
    }

    private void dfs(int amount, int[] coins) {
        //触发结束条件
        if (amount == 0) {
            count++;
            return;
        }
        if (amount < 0) {
            return;
        }
        //选择列表
        for (int i = 0; i < coins.length; i++) {
            //backtrack
            dfs(amount - coins[i], coins);
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] coins = {1, 2, 5};
        int count = solution4.change(5, coins);
        System.out.println(count);
    }
}
