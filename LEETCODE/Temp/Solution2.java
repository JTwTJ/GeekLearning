package Temp;

import java.util.TreeSet;

/**
 * @author jiangwentao
 * @date 2021/6/23
 * @detail
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {

        int slow = 0, fast = 0;
        int max = 0;
        TreeSet<Character> window = new TreeSet<>();
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (!window.contains(c)) {
                window.add(c);
                fast++;
                max = Math.max(window.size(), max);
            } else {
                char d = s.charAt(slow);
                slow++;
                window.remove(d);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int abcabcbb = solution2.lengthOfLongestSubstring("abdcaddfg");
        System.out.println(abcabcbb);
    }
}
