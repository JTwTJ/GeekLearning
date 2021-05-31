import java.util.HashMap;

/**
 * @author jiangwentao
 * @date 2021/5/31
 * @detail 字符串的排列
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 提示：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution567 {

    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.put(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {

                }
            }
        }
    }
}
