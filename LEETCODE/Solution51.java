import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/10
 * @detail N 皇后
 * <p>
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution51 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] checkerBoard = new char[n][n];
        for (char[] chars : checkerBoard) {
            Arrays.fill(chars, '.');
        }
        dfs(checkerBoard, 0);
        System.out.println(checkerBoard[0][0] == '\u0000');
        return res;
    }

    private void dfs(char[][] checkerBoard, int row) {

        //base case
        if (row == checkerBoard.length) {
            res.add(convertTOList(checkerBoard));
            return;
        }
        //选择列表
        for (int col = 0; col < checkerBoard[0].length; col++) {
            if (!valid(checkerBoard, row, col)) {
                continue;
            }
            //做选择
            checkerBoard[row][col] = 'Q';
            //回溯
            dfs(checkerBoard, row + 1);
            //撤销选择
            checkerBoard[row][col] = '.';
        }
    }

    private List<String> convertTOList(char[][] checkerBoard) {
        List<String> res = new ArrayList<>(checkerBoard.length);
        for (char[] chars : checkerBoard) {
            res.add(String.valueOf(chars));
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < checkerBoard[0].length; j++) {
//                sb.append(chars[j] == '\u0000' ? '.' : 'Q');
//            }
//            res.add(sb.toString());
        }
        return res;
    }

    private boolean valid(char[][] checkerBoard, int row, int col) {

        //校验当前列上方是否合法
        for (int i = row - 1; i >= 0; i--) {
            if (checkerBoard[i][col] == 'Q') {
                return false;
            }
        }
        //校验当前位置的右上方是否合法
        for (int i = row - 1, j = col + 1; i >= 0 && j < checkerBoard[0].length; i--, j++) {
            if (checkerBoard[i][j] == 'Q') {
                return false;
            }
        }
        //校验当前位置的左上方是否合法
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (checkerBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> lists = solution51.solveNQueens(4);
        System.out.println(lists);
    }
}
