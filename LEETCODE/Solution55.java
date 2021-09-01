/**
 * @author jiangwentao
 * @date 2021/7/26
 * @detail 跳跃游戏
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *
 * 示例1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        return backtrack(nums.length - 1, nums);
    }

    //递归调用，从终点往起点找，要到达终点必须要满足终点的上一个起跳点能够跳到终点
    // （终点位置-上一个起跳点位置 <= 上一个位置的数组中的值），
    // 找不到直接返回false，找得到就以当前满足的点为终点继续向下找。
    private boolean backtrack(int max, int[] nums) {
        if(max == 0) {
            return true;
        }
        for (int i = max - 1; i >= 0; i--) {
            if (max - i <= nums[i]) {
                return backtrack(i, nums);
            }
        }
        return false;
    }

    //动态规划
    //解题思路：
    //1、如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
    //2、可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
    //3、如果可以一直跳到最后，就成功了
    public boolean canJump1(int[] nums) {
        //base case，表示当前位置能够跳到的最远的位置
        int cover = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > cover) {
                return false;
            }
            cover = Math.max(cover, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        boolean b = solution55.canJump(new int[]{2, 0, 0});
        System.out.println(b);
    }
}
