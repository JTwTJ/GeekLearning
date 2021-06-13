import java.util.HashMap;

/**
 * @author jiangwentao
 * @date 2021/6/13
 * @detail 和为K的子数组
 * 给定一个整数数组和一个整数k，你需要找到该数组中和为k的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数k的范围是[-1e7, 1e7]。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution560 {

    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int res = 0;
        HashMap<Integer, Integer> dic = new HashMap<>();
        dic.put(0, 1);
        int sum_i = 0;
        for(int i = 0; i < nums.length; i++) {
            sum_i += nums[i];
            int sum_j = sum_i - k;
            if (dic.containsKey(sum_j)) {
                res += dic.get(sum_j);
            }
            dic.put(sum_j, dic.getOrDefault(sum_j, 0) + 1);
//            sum[i + 1] = sum[i] + nums[i];
        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (sum[i + 1] - sum[j] == k) {
//                    res++;
//                }
//            }
//        }
        return res;
    }
}
