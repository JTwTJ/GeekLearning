import java.util.Arrays;

/**
 * @author jiangwentao
 * @date 2021/6/16
 * @detail 编辑距离
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution72 {

    //递归动态规划+备忘录----自顶向下
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        memo = new int[len1][len2];
        for (int[] temp : memo) {
            Arrays.fill(temp, -1);
        }
        return dp(word1, word2, len1 - 1, len2 - 1);
    }

    private int dp(String word1, String word2, int len1, int len2) {
        //base case
        //word1自顶向下已经遍历完，后面的最少操作数为word2的剩余的长度
        if (len1 < -1) {
            return len2 + 1;
        }

        //word2自顶向下已经遍历完，后面的最少操作数为word1的剩余的长度
        if (len2 < -1) {
            return len1 + 1;
        }
        //备忘录中存在这直接取，不去递归
        if (memo[len1][len2] != -1) {
            return memo[len1][len2];
        }
        //如果该处位置的字符已经匹配则不作任何操作（也不会加1）
        if (word1.charAt(len1) == word2.charAt(len2)) {
            return dp(word1, word2, len1 - 1, len2 - 1);
        } else {
            //如果遍历到的位置的字符不匹配，那么会有替换、删除、插入三种操作可供选择，然后取这个子问题中最优解
            int min = min(
                    //替换操作 两个字符串的位置继续向下探索
                    dp(word1, word2, len1 - 1, len2 - 1),
                    //删除操作 被操作字符串位置继续向下探索，参考字符串位置不变
                    dp(word1, word2, len1 - 1, len2),
                    //插入操作 在比较位置插入了字符 相当于被操作字符串不变，参考字符串位置继续向下探索
                    dp(word1, word2, len1, len2 - 1)) + 1;
            memo[len1][len2] = min;
            return min;
        }
    }

    private int min(int dp, int dp1, int dp2) {
        return Math.min(Math.min(dp, dp1), dp2);
    }
}
