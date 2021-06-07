/**
 * @author jiangwentao
 * @date 2021/6/7
 * @detail 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 19
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution96 {

    int[][] nemo;

    public int numTrees(int n) {
        //新建备忘录，消除重叠子问题
        nemo = new int[n + 1][n + 1];
        // 计算闭区间 [1, n] 组成的 BST 个数
        return count(1, n);
    }

    /* 计算闭区间 [lo, hi] 组成的 BST 个数 */
    int count(int lo, int hi) {
        // base case
        if (lo > hi) {
            return 1;
        }
        if (nemo[lo][hi] != 0) {
            return nemo[lo][hi];
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // i 的值作为根节点 root
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            // 左右子树的组合数乘积是 BST 的总数
            res += left * right;
        }
        nemo[lo][hi] = res;
        return res;
    }
}
