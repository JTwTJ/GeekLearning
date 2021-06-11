import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/11
 * @detail 子集
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution78 {

    private final List<List<Integer>> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new LinkedList<>(), 0);
        return path;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, int start) {

        path.add(new LinkedList<>(track));
        //选择列表
        for (int i = start; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);
            backtrack(nums, track, i + 1);
            track.removeLast();
        }
    }

    //方法二是运用数学中集合的并集知识
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets1(int[] nums) {

        res.add(new ArrayList<>());
        dfs(nums, nums.length - 1);
        return res;
    }

    private void dfs(int[] nums, int start) {

        //base case
        if (start == -1) {
            return;
        }

        List<List<Integer>> copyRes = new ArrayList<>(res);
        for (List<Integer> temp : copyRes) {
            ArrayList<Integer> copyList = new ArrayList<>(temp);
            copyList.add(nums[start]);
            res.add(copyList);
        }
        dfs(nums, start - 1);
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        List<List<Integer>> subsets = solution78.subsets1(new int[]{1, 2, 3, 4});
        System.out.println(subsets);
    }
}
