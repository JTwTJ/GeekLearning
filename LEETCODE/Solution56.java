import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jiangwentao
 * @date 2021/6/23
 * @detail 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int[][] res = new int[intervals.length][2];
        int index = 0;
        for (int[] interval : intervals) {
            if (index == 0) {
                res[index] = interval;
                index++;
            } else if (res[index - 1][1] < interval[0]) {
                res[index] = interval;
                index++;
            } else {
                if (res[index - 1][1] < interval[1]) {
                    res[index - 1][1] = interval[1];
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(new int[][]{{1, 4}, {2, 3}});
        System.out.println(Arrays.toString(merge));
    }
}
