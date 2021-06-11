import java.util.*;

/**
 * @author jiangwentao
 * @date 2021/5/19
 * @detail 全排列  --回溯算法
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution46 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        Stack<Integer> track = new Stack<>();
        dfs(nums, track);
        return res;
    }

    private void dfs(int[] nums, Stack<Integer> track) {
        //结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        //做选择
        for (int i = 0; i < nums.length; i++) {

            if (track.contains(nums[i])) {
                continue;
            }
            track.push(nums[i]);
            //backtrack
            dfs(nums, track);
            //撤销选择
            track.pop();
        }
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] coins = {1, 5, 2};
        List<List<Integer>> permute = solution46.permute(coins);
        System.out.println(permute);
    }
}
