import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/10
 * @detail 划分为k个相等的子集
 * 给定一个整数数组nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution698 {

    boolean[] visited;
    int count = 0;
    List<List<Integer>> path = new ArrayList<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        visited = new boolean[k];
        return dfs(nums, target, k);
    }

    private boolean dfs(int[] nums, int target, int k) {
        //base case
        if (path.size() == k) {
            return true;
        }
        //选择列表
        List<Integer> collect = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //判断是否跳过选择
            if (visited[i]) {
                continue;
            }
            if (count + nums[i] > target) {
                continue;
            }
            if(count + nums[i] == target) {
                visited[i] = true;
                collect.add(nums[i]);
            }
            //做选择
            visited
            dfs(nums, target, k);
        }
    }
}
