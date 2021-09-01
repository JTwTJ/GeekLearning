/**
 * @author jiangwentao
 * @date 2021/7/26
 * @detail 跳跃游戏 II
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution45 {

    private int res = 0;
    private boolean done = false;
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        backtrack(nums.length - 1, nums);
        return res;
    }

    private void backtrack(int max, int[] nums) {
        if(max == 0) {
            done = true;
            return;
        }
        for (int i = 0; i < max; i++) {
            if (max - i <= nums[i] && !done) {
                res++;
                backtrack(i, nums);
            }
        }
    }

    public int jump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int jump = solution45.jump1(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }
}
