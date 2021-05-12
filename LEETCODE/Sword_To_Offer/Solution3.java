package Sword_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/5/6
 * @detail 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {

    public String replaceSpace(String s) {
//        return s.replaceAll(" ", "%20");
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = "we are happy";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.replaceSpace(test));
    }
}
