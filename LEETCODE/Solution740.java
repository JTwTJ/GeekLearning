

/**
 * @author jiangwentao
 * @date 2021/7/26
 * @detail 删除并获得点数
 * 给你一个整数数组nums，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，
 * 你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution740 {

    //打家劫舍变种（动态规划）相邻数字金额的不能同时窃取
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //定义一个数组表示当前位置下的数字有几个
        int max = 0;
        //找出最大值，作为数组长度
        for (int item : nums) {
            max = Math.max(max, item);
        }
        //当前数字脚标下的数字个数
        int[] value = new int[max + 1];
        for (int item : nums) {
            value[item]++;
        }
        //打家劫舍
        int[] dp = new int[value.length];
        dp[0] = value[0];
        dp[1] = Math.max(value[0], value[1]);
        for (int i = 2; i < value.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + value[i] * i);
        }
        return dp[value.length - 1];
    }
}
