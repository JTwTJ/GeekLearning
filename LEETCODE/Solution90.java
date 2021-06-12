import java.util.*;

/**
 * @author jiangwentao
 * @date 2021/6/12
 * @detail 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution90 {

    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        res.add(new ArrayList<>());
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int start, LinkedList<Integer> track) {

        //base case
        LinkedList<Integer> temp = new LinkedList<>(track);
        Collections.sort(temp);
        if (!res.contains(temp)) {
            res.add(temp);
        }
        //选择列表
        for (int i = start; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);
            dfs(nums, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        List<List<Integer>> subsets = solution90.subsets(new int[]{0});
        System.out.println(subsets);
    }
}
