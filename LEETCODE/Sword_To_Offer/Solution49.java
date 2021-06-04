package Sword_To_Offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jiangwentao
 * @date 2021/5/30
 * @detail 滑动窗口的最大值
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution49 {

    //暴力解法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] maxNums = new int[nums.length - k + 1];
        int end = k - 1;
        for (int i = 0; i <= nums.length - k; i++) {
            int max = findMax(nums, i, end++);
            maxNums[i] = max;
        }
        return maxNums;
    }

    private int findMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    //单调队列

    class MonotonicQueue {

        private LinkedList<Integer> queue = new LinkedList<>();

        //队尾添加元素
        void push(int n) {
            //将前面小于自己的元素都删除
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }

        //返回当前队列中的最大元素
        int max() {
            //队头元素是最大元素
            return queue.getFirst();
        }

        //队尾元素如果是n，删除它
        void pop(int n) {
            if (n == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先把窗口的前k - 1 填满
                window.push(nums[i]);
            } else {
                //窗口开始向前滑动
                //移入新元素
                window.push(nums[i]);
                //将当前窗口中的最大元素计入结果
                res[i - k + 1] = window.max();
                //移除最后的队尾元素
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = solution49.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}
