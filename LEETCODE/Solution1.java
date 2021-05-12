
/**
 * 对一个数开方并保留指定小数位
 *
 * @author jiangwentao
 * @date 2021/4/1
 */
public class Solution1 {

    /**
     * 最后开方的结果
     */
    public static float finalResult = 0;

    public static int count = 0;

    /**
     * 保留的小数位数
     */
    public static int places = 4;

    public static void main(String[] args) {

        solution(15.42f);
        System.out.println(finalResult);
    }

    /**
     * 注：四位小数以内能直接开方的直接返回，开方开不尽的保留四位小数位！！！
     *
     * @param x 传参
     */
    private static void solution(float x) {

        int i = 0;
        while (true) {
            //如果正好匹配上直接返回
            if ((i * i) == x) {
                finalResult = i;
                break;
            }
            if ((i * i) < x && x < (i + 1) * (i + 1)) {
                //整数部分匹配上，接着匹配小数部分
                finalResult = i;
                result(0.1f, x);
                break;
            }
            i++;
        }
    }

    private static void result(float f, float x) {
        count++;
        if (count == places + 1) {
            return;
        }
        for (int j = 1; j < 10; j++) {
            float tempResult = j * f + finalResult;
            float tempResult2 = (j + 1) * f + finalResult;
            //如果能开整方的直接返回，不用后面补0留四位
            if ((tempResult * tempResult) == x) {
                finalResult = j * f + finalResult;
                return;
            }
            if ((tempResult2 * tempResult2) == x) {
                finalResult = (j + 1) * f + finalResult;
                return;
            }
            //如果在区间之内直接向下一个进制递归
            if ((tempResult * tempResult) < x && x < (tempResult2 * tempResult2)) {
                finalResult = j * f + finalResult;
                //递归往下
                result(f / 10, x);
            }
        }
    }
}
