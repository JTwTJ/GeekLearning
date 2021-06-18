package Sword_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/6/17
 * @detail 正则表达式匹配
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素,
 * 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释:".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母以及字符.和*，无连续的 '*'。
 * 注意：本题与主站 10题相同：https://leetcode-cn.com/problems/regular-expression-matching/
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution19 {

    int matcheCount = 0;

    public boolean isMatch(String s, String p) {

        return dp(s, p, 0, 0);
    }

    private boolean dp(String s, String p, int i, int j) {

        //base case
        if (matcheCount == s.length()) {
            return true;
        }
        if (i >= s.length() || j >= p.length()) {
            return false;
        }
        if (s.charAt(i) != p.charAt(j)) {
            if (p.charAt(j) == '*' && s.charAt(i) == p.charAt(j - 1)) {
                i++;
                matcheCount++;
            } else if (p.charAt(j) == '.' && (j + 1 < p.length())) {
                if (p.charAt(j + 1) == '*') {
                    i++;
                } else {
                    i++;
                    j++;
                }
                matcheCount++;
            } else {
                j++;
            }
        } else {
            i++;
            j++;
            matcheCount++;
        }
        return dp(s, p, i, j);
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        boolean aab = solution19.isMatch("aaa", ".*");
        System.out.println(aab);
    }
}
