import java.util.Arrays;

/**
 * @author jiangwentao
 * @date 2021/4/27
 * @detail
 */
public class SelfMadeAlgorithm {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //快速排序
    private static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = left;
        while (left < right) {
            while ((left < right) && arr[left] <= arr[pivot]) {
                left++;
            }
            if ((left < right) && arr[left] > arr[pivot]) {
                swap(arr, left, pivot);
                pivot = left;
            }
            while ((left < right) && arr[right] >= arr[pivot]) {
                right--;
            }
            if ((left < right) && arr[right] < arr[pivot]) {
                swap(arr, right, pivot);
                pivot = right;
            }
            quickSort(arr, start, left - 1);
            quickSort(arr, left + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{9, 8, 7, 5, 4, 22, 456, 11, 78, 54, 12, 45, 89, 34, 23, 11, 67, 112, 11, 9, 8, 7, 2};
        int[] ints5 = Arrays.copyOf(arr, arr.length);
        quickSort(ints5, 0, arr.length - 1);
        System.out.println(Arrays.toString(ints5));
    }
}
