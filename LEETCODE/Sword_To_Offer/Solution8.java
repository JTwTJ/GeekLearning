package Sword_To_Offer;

import java.util.HashMap;

/**
 * @author jiangwentao
 * @date 2021/5/11
 * @detail 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution8 {

    public static HashMap<Integer, Integer> tempMap = new HashMap<>();

    //斐波那契数列、递归
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (tempMap.containsKey(n)) {
            return tempMap.get(n);
        }
        int step = (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        tempMap.put(n, step);
        return step;
    }

    //动态规划
    public int dpNumWays(int n) {
        int i = 1;
        int j = 1;
        int sum;
        for (int k = 1; k < n; k++) {
            sum = i + j;
            i = j;
            j = sum;
        }
        return j;
    }

    //dp动态规划
    public int dpArr(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        //base case
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int numWays = solution8.numWays(2);
        int i = solution8.dpArr(2);
        int i1 = solution8.dpNumWays(2);
        System.out.println(numWays + "------" + i + "-----" + i1);
    }
}
