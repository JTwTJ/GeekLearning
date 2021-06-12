import java.util.*;

/**
 * @author jiangwentao
 * @date 2021/6/12
 * @detail 组合总和
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution39 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        int left = 0, right = candidates.length - 1;
        while (left < right) {
            int temp = candidates[left];
            candidates[left] = candidates[right];
            candidates[right] = temp;
            left++;
            right--;
        }
        traverse(candidates, target, new LinkedList<>(), 0);
        return res;
    }

    private void traverse(int[] candidates, int target, LinkedList<Integer> track, int sum) {
        //base case
//        int sum = sum(track);
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(track);
            Collections.sort(temp);
            if (!res.contains(temp)) {
                res.add(new LinkedList<>(temp));
            }
            return;
        }
        //选择列表
        for (int candidate : candidates) {
            if (sum + candidate > target) {
                continue;
            }
            //做选择
            track.add(candidate);
            sum += candidate;
            traverse(candidates, target, track, sum);
            track.removeLast();
            sum -= candidate;
        }
    }

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        List<List<Integer>> lists = solution39.combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9);
        System.out.println(lists);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        Set<List<Integer>> set = new HashSet<>();
        set.add(list1);
        set.add(list2);
        System.out.println(set.contains(list1));
    }
}
