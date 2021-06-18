import java.util.LinkedList;

/**
 * @author jiangwentao
 * @date 2021/6/18
 * @detail 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution198 {

    int max = 0;

    //回溯算法、时间复杂度爆炸
    public int rob(int[] nums) {

        backtrack(nums, new LinkedList<Integer>(), 0);
        return max;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, int start) {
        //base case
        if (start > nums.length - 1) {
            System.out.print(track);
            int tempMax = track.stream().mapToInt(e -> e).sum();
            max = Math.max(tempMax, max);
            return;
        }
        //选择列表
        for (int i = start; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);
            backtrack(nums, track, i + 2);
            track.removeLast();
        }
    }

    public int robDP(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        //定义数组
        int[] dp = new int[len];
        //base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //选择列表
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        int rob = solution198.rob(new int[]{2, 7, 9, 3, 1});
        int i = solution198.robDP(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob + "-----" + i);
    }
}
