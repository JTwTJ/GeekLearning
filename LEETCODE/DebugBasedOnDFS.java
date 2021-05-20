/**
 * @author jiangwentao
 * @date 2021/5/20
 * @detail
 * 递归调试一些想法可以清楚打印调用栈、入参与结果
 */
public class DebugBasedOnDFS {

    static int count = 0;

    static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }

    static void dp(int j, int i) {
        printIndent(count++);
        System.out.println("i = " + i + ", j = " + j);
        if (j == 9) {
            printIndent(--count);
            System.out.println("return" + (i + j));
            return;
//            return 0;
        }
        dp(++i, ++j);
        //撤销选择
        i--;
        j--;
        printIndent(--count);
        System.out.println("return " + (i + j));
    }

    public static void main(String[] args) {
        dp(0, 0);
    }
}