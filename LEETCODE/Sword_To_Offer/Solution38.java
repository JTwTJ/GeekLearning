package Sword_To_Offer;

import java.util.*;

/**
 * @author jiangwentao
 * @date 2021/6/9
 * @detail 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution38 {

    Set<String> res = new HashSet<>();
    private boolean[] visited;
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        visited = new boolean[chars.length];
        dfs(chars, new  StringBuilder());
        return res.toArray(new String[0]);
    }

    private String listToStr(List<Character> list) {

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);
        return sb.toString();
    }

    private void dfs(char[] chars, StringBuilder sb) {

        //base case
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }

        //选择列表
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            //做选择
            sb.append(chars[i]);
            visited[i] = true;
            dfs(chars, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        String[] abcs = solution38.permutation("aab");
        System.out.println(Arrays.toString(abcs));
    }
}
