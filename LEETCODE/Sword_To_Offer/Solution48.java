package Sword_To_Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangwentao
 * @date 2021/6/3
 * @detail 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution48 {

    public int lengthOfLongestSubstring(String s) {
        int fast = 0;
        int slow = 0;
        int maxLen = 0;
        Set<Character> window = new HashSet<>();
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (window.contains(c)) {
                char d = s.charAt(slow);
                window.remove(d);
                slow++;
            } else {
                window.add(c);
                if (maxLen < window.size()) {
                    maxLen = window.size();
                }
                fast++;
            }
        }
        return maxLen;
    }
}
