package Sword_To_Offer;

import java.util.Arrays;

/**
 * @author jiangwentao
 * @date 2021/5/18
 * @detail 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// todo
public class Solution16 {

    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < Math.pow(10, n) - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
//
//    char[] loop = {'0', '1','2', '3', '4', '5','6', '7', '8', '9'};
//    int dfsCount = 0;
//    public int[] printNumbers1(int n) {
//        for (int i = 1; i <= n; i++) {
//            dfs(i);
//        }
//    }
//
//    private void dfs(int i) {
//        if (i == dfsCount) {
//            return;
//        }
//
//        dfs();
//
//    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] ints = solution16.printNumbers(3);
        System.out.println(Arrays.toString(ints));
    }
}
