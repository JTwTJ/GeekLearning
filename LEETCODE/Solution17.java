import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/12
 * @detail 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution17 {

    char[][] dic = new char[][]{{' '}, {' '}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        String[] nums = digits.split("");
        traverse(nums, new StringBuilder(), 0);
        return res;
    }

    private void traverse(String[] digits, StringBuilder sb, int index) {

        //base case
        if (index == digits.length) {
            res.add(sb.toString());
            return;
        }
        //选择列表
        for (int i = 0; i < dic[Integer.parseInt(digits[index])].length; i++) {
            sb.append(dic[Integer.parseInt(digits[index])][i]);
            traverse(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations("");
        System.out.println(strings);
    }
}
