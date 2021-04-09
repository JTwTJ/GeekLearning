package LEETCODE;

import java.util.Arrays;

/**
 * 常用算法
 *
 * @author jiangwentao
 * @date 2021/3/11
 */
public class BaseAlgorithm {

    /**
     * 二分查找算法
     */
    private static Integer binarySearch(Integer data, Integer[] sortArr) {
        if (data < sortArr[0] || data > sortArr[sortArr.length - 1]) {
            throw new RuntimeException("暂无匹配数据");
        }
        int start = 0;
        int end = sortArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data.equals(sortArr[mid])) {
                return mid;
            }
            if (data > sortArr[mid]) {
                start = mid + 1;
            }
            if (data < sortArr[mid]) {
                end = mid - 1;
            }
        }
        throw new RuntimeException("暂无匹配数据");
    }

    /**
     * 冒泡排序
     */
    private static Integer[] bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     */
    private static Integer[] pickSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序
     */
    private static Integer[] insertSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     */
    private static void quickSort(Integer[] arr, int left, int right) {

        //如果左游标和右游标相等 或者 左游标大于右游标时 停止快排
        if (left >= right) {
            return;
        }
        //定义每次递归数组的起始位置与结束位置
        int start = left;
        int end = right;
        //定义比较基准
        int pivot = left;
        //如果左游标比右游标小则一直进行比较
        while (left < right) {
            //首先从最右往最左遍历查询,如果pivot比右边的遍历值都小，则右游标一直向左移动
            while ((left < right) && arr[pivot] <= arr[right]) {
                right--;
            }
            //如果遇到了pivot比右边的遍历值大的情况，则进行pivot与遍历值的交换，并且把pivot脚标改为当前遍历值的下标
            if (arr[pivot] > arr[right]) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
                pivot = right;
            }
            //然后从最左往最右遍历查询,如果pivot比左边的遍历值都大，则左游标一直向右移动
            while ((left < right) && arr[pivot] >= arr[left]) {
                left++;
            }
            //如果遇到了pivot比左边的遍历值小的情况，则进行pivot与遍历值的交换，并且把pivot脚标改为当前遍历值的下标
            if (arr[pivot] < arr[left]) {
                int temp = arr[left];
                arr[left] = arr[pivot];
                arr[pivot] = temp;
                pivot = left;
            }
        }
        //递归左边分而治之
        quickSort(arr, start, left - 1);
        //递归右边分而治之
        quickSort(arr, left + 1, end);
    }

    /**
     * 希尔排序
     */
    public static void shellSort() {
    }

    public static void main(String[] args) {
        //二分查找
        Integer[] sortArr = new Integer[]{1, 3, 5, 6, 8, 9, 16};
        Integer integer = binarySearch(15, sortArr);
        System.out.println(integer);

        Integer[] arr = new Integer[]{9, 8, 7, 5, 4, 2, 6};
        //冒泡排序
        Integer[] integers1 = bubbleSort(arr);
        System.out.println(Arrays.toString(integers1));
        //选择排序
        Integer[] integers2 = pickSort(arr);
        System.out.println(Arrays.toString(integers2));
        //插入排序
        Integer[] integers3 = insertSort(arr);
        System.out.println(Arrays.toString(integers3));
        //快速排序
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
