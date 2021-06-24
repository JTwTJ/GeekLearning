import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jiangwentao
 * @date 2021/6/24
 * @detail 满足条件的子序列数目
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 * <p>
 * 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * 示例 3：
 * <p>
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 * 示例 4：
 * <p>
 * 输入：nums = [5,2,4,1,7,6,8], target = 16
 * 输出：127
 * 解释：所有非空子序列都满足条件 (2^7 - 1) = 127
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 1 <= target <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1498 {

    private int res = 0;

    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);
        int right = nums.length - 1;
        while (right > 0) {
            if (nums[0] + nums[right] <= target) {
                break;
            }
            right--;
        }
        int[] ints = Arrays.copyOfRange(nums, 0, right + 1);
        backtrack(ints, target, new LinkedList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, int target, LinkedList<Integer> track, int start) {

        if (track.size() >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            track.add(i);
            if (nums[track.getFirst()] + nums[track.getLast()] <= target) {
                res += 1;
            }
            backtrack(nums, target, track, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution1498 solution1498 = new Solution1498();
        int i = solution1498.numSubseq(new int[]{7, 10, 7, 5, 6, 7, 3, 4, 9, 6}, 9);
        System.out.println(i);
    }
}
