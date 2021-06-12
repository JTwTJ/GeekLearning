import java.util.*;

/**
 * @author jiangwentao
 * @date 2021/6/11
 * @detail 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution22 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return new ArrayList<>(res);
    }

    private void backtrack(int left, int right, StringBuilder sb) {

        //base case
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        //left 大于 right不合法
        if (left > right) {
            return;
        }
        //left 小于 0 不合法
        if (left < 0) {
            return;
        }
        //尝试放一个左括号
        sb.append('(');
        backtrack(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);
        //尝试放一个右括号
        sb.append(')');
        backtrack(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(8);
        System.out.println(strings);
    }
}
