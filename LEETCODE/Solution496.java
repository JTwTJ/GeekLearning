import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jiangwentao
 * @date 2021/6/4
 * @detail 下一个更大元素 I
 * 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
 * <p>
 * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。
 * <p>
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        //hash表记录数组下标所在位置
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            map.put(nums1[i], i);
        }
        //单调栈运用于需要去查结果的数组nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (map.containsKey(nums2[i]) && !stack.isEmpty()) {
                res[map.get(nums2[i])] = stack.peek();
            }
            stack.push(nums2[i]);
        }
        return res;
    }
}
