package Sword_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/5/11
 * @detail 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution7 {

    //方法1:常规递归斐波那契
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //方法2:动态规划 斐波那契
    public int dpFib(int n) {
        if (n == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        int sum;
        for (int k = 1; k < n; k++) {
            sum = i + j;
            i = j;
            j = sum;
        }
        return j;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int fib = solution7.fib(5);
        System.out.println(fib);
    }
}
