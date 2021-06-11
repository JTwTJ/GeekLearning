import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/11
 * @detail 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入:n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution77 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        backtrack(n, k, 1, new LinkedList<>());
        return res;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> track) {

        //base case
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        //选择列表
        for (int i = start; i <= n; i++) {
            //做选择
            track.add(i);
            //dfs
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        List<List<Integer>> combine = solution77.combine(4, 2);
        System.out.println(combine);
    }
}
