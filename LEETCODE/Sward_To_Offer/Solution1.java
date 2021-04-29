package Sward_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/4/29
 * @detail 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {

    public static int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int value = nums[i];
            if (value == i) {
                i++;
                continue;
            }
            if (value == nums[value]) {
                return value;
            } else {
                int temp = nums[i];
                nums[i] = nums[value];
                nums[value] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }
}
