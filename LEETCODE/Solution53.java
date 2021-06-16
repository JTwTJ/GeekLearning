/**
 * Created with IntelliJ IDEA.
 * User: msi-
 * Date: 2021/6/16
 * Time: 0:22
 * Description: 最大子序和
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // base case
        // 第一个元素前面没有子数组
        int dp_0 = nums[0];
        int dp_1 = 0;
        int res = dp_0;
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            //dp定义为以该位置结尾的数组（必须包含该位置）的最大子数组，不是该数组的最大子数组
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int i = solution53.maxSubArray(new int[]{-3, 4, -1, 2, -6});
        System.out.println(i);
    }
}
