package Sword_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/5/13
 * @detail 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution10 {

    //我的方法 有些瑕疵
//    private int maxXLength;
//    private int maxYLength;
//    private int count;
//    //节点是否已使用map
//    private List<String> usedNodeList;
//
//    public boolean exist(char[][] board, String word) {
//        char[] wordChars = word.toCharArray();
//        //首先找到首字母的可能性坐标
//        this.maxXLength = board[0].length;
//        this.maxYLength = board.length;
//        if (maxYLength * maxXLength < wordChars.length) {
//            return false;
//        }
//        List<String> headPositions = new ArrayList<>();
//        for (int x = 0; x < maxXLength; x++) {
//            for (int y = 0; y < maxYLength; y++) {
//                if (board[y][x] == wordChars[0]) {
//                    String position = x + "," + y;
//                    headPositions.add(x + "," + y);
//                }
//            }
//        }
//        boolean result = false;
//        if (headPositions.size() == 0) {
//            return false;
//        }
//        for (String headPosition : headPositions) {
//            //每次寻迹之前初始化使用节点记录map、count
//            usedNodeList = new ArrayList<>(maxXLength * maxYLength);
//            count = 0;
//            String[] position = headPosition.split(",");
//            int x = Integer.parseInt(position[0]);
//            int y = Integer.parseInt(position[1]);
//            //查询当前节点的下一个节点是否能够匹配上
//            usedNodeList.add(x + "," + y);
//            result = checkExist(x, y, wordChars, board);
//            //如果已经查到了存在一条路径那么直接终止循环查询
//            if (result) {
//                break;
//            }
//        }
//        return result;
//    }
//
//    private boolean checkExist(int x, int y, char[] wordChars, char[][] board) {
//        if (++count == wordChars.length) {
//            return true;
//        }
//        if (x >= maxXLength || y >= maxYLength) {
//            return false;
//        }
//        //判断当前节点水平方向的有无匹配节点
//        //如果当前节点已被使用过且水平左存在且匹配那么递归寻找下一个节点
//        if ((x - 1) >= 0 && board[y][x - 1] == wordChars[count]
//                && !usedNodeList.contains((x - 1) + "," + y)) {
//            usedNodeList.add((x - 1) + "," + y);
//            boolean result = checkExist(x - 1, y, wordChars, board);
//            if (result || usedNodeList.contains((x - 1) + "," + y)) {
//                return result;
//            }
//        }
//        //如果当前节点已被使用过且水平右存在且匹配那么递归寻找下一个节点
//        if ((x + 1) < maxXLength && board[y][x + 1] == wordChars[count]
//                && !usedNodeList.contains((x + 1) + "," + y)) {
//            usedNodeList.add((x + 1) + "," + y);
//            boolean result = checkExist(x + 1, y, wordChars, board);
//            if (result || usedNodeList.contains((x + 1) + "," + y)) {
//                return result;
//            }
//        }
//        //如果当前节点已被使用过且垂直上存在且匹配那么递归寻找下一个节点
//        if ((y - 1) >= 0 && board[y - 1][x] == wordChars[count]
//                && !usedNodeList.contains(x + "," + (y - 1))) {
//            usedNodeList.add(x + "," + (y - 1));
//            boolean result = checkExist(x, y - 1, wordChars, board);
//            if (result || usedNodeList.contains(x + "," + (y - 1))) {
//                return result;
//            }
//        }
//        //如果当前节点已被使用过且垂直下存在且匹配那么递归寻找下一个节点
//        if ((y + 1) < maxYLength && board[y + 1][x] == wordChars[count]
//                && !usedNodeList.contains(x + "," + (y + 1))) {
//            usedNodeList.add(x + "," + (y + 1));
//            return checkExist(x, y + 1, wordChars, board);
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Solution10 solution10 = new Solution10();
//        char[][] board = {{'A', 'B'}, {'C', 'D'}};
//        String word = "ABCD";
//        boolean exist = solution10.exist(board, word);
//        System.out.println(exist);
//    }

    //DFS+剪枝实现
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = dfs(i, j, board, words, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, char[] words, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length
                || j < 0 || words[k] != board[i][j]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(i - 1, j, board, words, k + 1)
                || dfs(i - 1, j, board, words, k + 1)
                || dfs(i, j - 1, board, words, k + 1)
                || dfs(i, j + 1, board, words, k + 1);
        board[i][j] = words[k];
        return res;
    }
}
