package Temp;

/**
 * @author jiangwentao
 * @date 2021/9/1
 * @detail 现有一个n*m的二维矩阵， 请按照如下规则转换为一个新的n*m的矩阵：
 * 统计每一个元素所在行、所在列比该元素大的个数之和，作为新矩阵相同位置的值。
 * 例如：
 * 输入    输出
 * 123     432
 * 456     321
 * 789     210
 */
public class Test {

    private static int x = 0;
    private static int y = 0;

    private int[][] solution(int[][] test) {

        x = test[0].length;
        y = test.length;
        int[][] res = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int cur = test[i][j];
                int countX = countX(test, cur, i, 0);
                int countY = countY(test, cur, 0, j);
                res[i][j] = countX + countY;
            }
        }
        return res;
    }

    private int countY(int[][] test, int cur, int i, int j) {
        int count = 0;
        for (int k = i; k < y; k++) {
            if (test[k][j] > cur) {
                count++;
            }
        }
        return count;
    }

    private int countX(int[][] test, int cur, int i, int j) {
        int count = 0;
        for (int k = j; k < x; k++) {
            if (test[i][k] > cur) {
                count++;
            }
        }
        return count;
    }
//
//    private int[][] solution2(int[][] test) {
//        x = test[0].length;
//        y = test.length;
//        for (int i = 0; i < y; i++) {
//            Arrays.sort(test[i]);
//            int countX =
//        }
//        for (int)
//    }

    public static void main(String[] args) {
        int[][] test = {{2, 1, 3}, {4, 5, 6}, {7, 8, 9}};
        Test a = new Test();
        int[][] res = a.solution(test);
        System.out.println(res);
    }
}
