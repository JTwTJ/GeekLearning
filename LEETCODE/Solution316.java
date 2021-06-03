import java.util.Stack;

/**
 * @author jiangwentao
 * @date 2021/6/3
 * @detail 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
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
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution316 {

    public String removeDuplicateLetters(String s) {
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

    public static void main(String[] args) {
        Solution316 solution316 = new Solution316();
        String test = solution316.removeDuplicateLetters("cbacdcbc");
        System.out.println(test);
    }
}
