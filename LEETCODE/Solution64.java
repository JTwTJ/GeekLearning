import java.util.Arrays;

/**
 * @author jiangwentao
 * @date 2021/6/16
 * @detail 最小路径和
 * 给定一个包含非负整数的 m x n网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution64 {

    int[][] memo;

    //动态规划+备忘录 自顶向下
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] temp : memo) {
            Arrays.fill(temp, -1);
        }
        return dp(grid, m - 1, n - 1);
    }

    private int dp(int[][] grid, int m, int n) {
        //base case
        if (m == 0 && n == 0) {
            return grid[0][0];
        }
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        memo[m][n] = Math.min(dp(grid, m - 1, n), dp(grid, m, n - 1)) + grid[m][n];
        return memo[m][n];
    }

    //自底向上
    public int minPathSumFromBottomToTop(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
