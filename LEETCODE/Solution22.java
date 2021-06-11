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

    Set<String> res = new HashSet<>();
    HashMap<Character, Integer> dic = new HashMap<>(2);
    public List<String> generateParenthesis(int n) {

        char[] resources = new char[n * 2];
        for (int i = 0; i < n * 2; i ++) {
            if (i % 2 == 0) {
                resources[i] = '(';
            } else {
                resources[i] = ')';
            }
        }
        dic.put('(', n);
        dic.put(')', n);
        backtrack(resources, new StringBuilder());
        return new ArrayList<>(res);
    }

    private void backtrack(char[] resources, StringBuilder sb) {
        if (sb.length() == resources.length) {
            res.add(sb.toString());
            return;
        }
        //选择列表
        for (int i = 0; i < resources.length; i++) {
            char curChar = i % 2 == 0 ? '(' : ')';
            if (dic.get(curChar) == 0) {
                continue;
            }
            //做选择
            dic.put(curChar, dic.get(curChar) - 1);
            sb.append(curChar);
            if (i <= resources.length / 2 && dic.get('(') > dic.get(')')) {
                dic.put(curChar, dic.get(curChar) + 1);
                continue;
            }
            backtrack(resources, sb);
            dic.put(curChar, dic.get(curChar) + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(3);
        System.out.println(strings);
    }
}
