import java.util.Arrays;

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

    int[] bucket;
    int target;

    //以数字为视角装入桶
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        bucket = new int[k];
        target = sum / k;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return backtrack(nums, 0);
    }

    private boolean backtrack(int[] nums, int index) {

        //base case
        if (index == nums.length) {
            for (int sum : bucket) {
                if (sum != target) {
                    return false;
                }
            }
            return true;
        }
        if (nums[index] > target) {
            return false;
        }

        //选择列表
        for (int i = 0; i < bucket.length; i++) {
            //跳过条件
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            //做选择
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1)) {
                return true;
            }
            //撤销选择
            bucket[i] -= nums[index];
        }
        return false;
    }

    //以桶的视角
    private boolean[] visited;
    public boolean canPartitionKSubsets2(int[] nums, int k) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        visited = new boolean[nums.length];
        target = sum / k;
        return backtrack(nums, k, 0, 0);
    }

    private boolean backtrack(int[] nums, int k, int bucketSum, int start) {

        //base case
        if (k == 0) {
            return true;
        }
        //如果这个桶装满了就递归装下一个桶
        if (bucketSum == target) {
            return backtrack(nums, k - 1, 0, 0);
        }
        //选择列表
        for (int i = start; i < nums.length; i++) {
            //剪枝
            if (visited[i]) {
                continue;
            }
            if (bucketSum + nums[i] > target) {
                continue;
            }
            //做选择
            bucketSum += nums[i];
            visited[i] = true;
            if (backtrack(nums, k, bucketSum, i + 1)){
                return true;
            }
            //撤销选择
            bucketSum -= nums[i];
            visited[i] = false;
        }
        return false;
    }
}
