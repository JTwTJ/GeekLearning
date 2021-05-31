import java.util.HashMap;

/**
 * @author jiangwentao
 * @date 2021/5/30
 * @detail 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution76 {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        char[] sArr = s.toCharArray();
        int left = 0, right = 0, valid = 0, start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口 找可行解
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                //将右移入合乎要求的字符窗口的值加一
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //debug 输出位置
            System.out.println("left=" + left + " and right=" + right);
            //判断左侧窗口是否要收缩
            while (valid == need.size()) {
                //这一步代码很关键，用来记录目前滑动的时候最小的子字符串的开始位置以及字符串长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //d 是将移除窗口的字符
                char d = s.charAt(left);
                //左移窗口 找最优解
                left++;
                //进行窗口的一系列更新
                if (need.containsKey(d)) {
                    //将匹配的字符左移移除窗口，并将合乎要求的数减一
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = solution76.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
