package Sword_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/5/17
 * @detail 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution12 {

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        int max = 1;
        for (int i = 2; i <= n; i++) {
            //整数部分
            int a = n / i;
            //余数部分
            int b = n % i;
            //计算乘积
            int multiplication = (int) (Math.pow(a, i - b) * Math.pow(a + 1, b));
            if (max < multiplication) {
                max = multiplication;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int max = solution12.cuttingRope(12);
        System.out.println(max);
    }
}
