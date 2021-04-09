

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author jiangwentao
 * @date 2021/3/23
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int friendNum = sc.nextInt();
//        Integer[] arr = new Integer[friendNum];
//        for (int i = 0; i < friendNum; i++) {
//            arr[i] = sc.nextInt();
//        }
//        String[] result = result(friendNum, arr);
//        String join = String.join(" ", result);
//        System.out.println(join);
//        int num = sc.nextInt();
//        Integer[] arr = new Integer[num];
//        for (int i = 0; i < num; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int max = sc.nextInt();
//        Integer integer = result1(num, arr, max);
////        System.out.println(integer);
        int length = sc.nextInt();
//        Integer[] arr1 = new Integer[length];
        String s1 = sc.next();
        String[] arr1 = s1.split("");
        String s2 = sc.next();
        String[] arr2 = s2.split("");
//        Integer[] arr2 = new Integer[length];
//        for (int i = 0; i < length; i++) {
//            arr2[i] = sc.nextInt();
//        }
        Integer integer = result3(arr1, arr2, length);
        System.out.println(integer);
    }

    private static String[] result(Integer friendNum, Integer[] arr) {
        String[] result = new String[friendNum];
        for (int i = 0; i < friendNum; i++) {
            for (int j = i; j < friendNum; j++) {
                if (arr[i] < arr[j]) {
                    result[i] = String.valueOf(j);
                    break;
                }
                if (j == friendNum - 1) {
                    result[i] = "0";
                }
            }
        }
        return result;
    }

    private static Integer result1(int num, Integer[] arr, int max) {
        int count = 0;
        //首先先把数组排序
        Arrays.sort(arr);
        List<Integer> usedList = new ArrayList<>();
        //首先先判断一个人组队
        for (int i = 0; i < num; i++) {
            if (arr[i] >= max) {
                count++;
                //将使用过的放进list
                usedList.add(arr[i]);
            }
        }
        //其次判断两个人组队
        for (int j = 0; j < num - 1; j++) {
            if (usedList.contains(arr[j])) {
                continue;
            }
            for (int k = j + 1; k < num; k++) {
                if (usedList.contains(arr[k])) {
                    continue;
                }
                if (arr[j] + arr[k] >= max) {
                    count++;
                    usedList.add(arr[j]);
                    usedList.add(arr[k]);
                }
            }
        }
        return count;
    }

    private static Integer result3(String[] arr1, String[] arr2, Integer length) {

        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr1[i].equals(arr1[j])) {
                    continue;
                }
                if ((Integer.valueOf(arr1[i]) | Integer.valueOf(arr2[i])) == (Integer.valueOf(arr1[j]) | Integer.valueOf(arr2[i])) &&
                        (Integer.valueOf(arr1[j]) | Integer.valueOf(arr2[j])) == (Integer.valueOf(arr1[i]) | Integer.valueOf(arr2[j]))) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}
