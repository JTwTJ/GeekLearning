import java.util.Stack;

/**
 * @author jiangwentao
 * @date 2021/6/3
 * @detail 不同字符的最小子序列
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 * <p>
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1081 {
    public String smallestSubsequence(String s) {
        int[] count = new int[256];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c] = count[c] + 1;
        }
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c] = count[c] - 1;
            if (inStack[c]) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek()) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                char popChar = stack.pop();
                inStack[popChar] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
