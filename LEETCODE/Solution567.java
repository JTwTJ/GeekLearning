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
            // c 是将移入窗口的字符
            char c = s2.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩  当字符长度满足匹配长度时进行判断是否包含所有
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                // d 是将移出窗口的字符
                char d = s2.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    //如果正好该字符凑齐但又会被移除，则valid-1
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    //窗口中的该字符数减一
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        boolean b = solution567.checkInclusion("hello", "ooolleoololeh");
        System.out.println(b);
    }
}
