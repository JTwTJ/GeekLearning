import java.util.HashSet;

/**
 * @author jiangwentao
 * @date 2021/6/1
 * @detail
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        HashSet<Character> window = new HashSet<>();
        while (right < s.length() && left < s.length()) {
            char c = s.charAt(right);
            if (window.contains(c)) {
                char d = s.charAt(left);
                left++;
                window.remove(d);
            } else {
                window.add(c);
                right++;
                int len = window.size();
                if (len > max) {
                    max = len;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int max = solution3.lengthOfLongestSubstring("");
        System.out.println(max);
    }
}
