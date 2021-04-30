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
    private static void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int start = left;
        int end = right;
        int pivot = left;
        while (left < right) {
            while ((left < right) && arr[right] >= arr[pivot]) {
                right--;
            }
            if ((left < right) && arr[right] < arr[pivot]) {
                swap(arr, right, pivot);
                pivot = right;
            }
            while ((left < right) && arr[left] <= arr[pivot]) {
                left++;
            }
            if ((left < right) && arr[left] > arr[pivot]) {
                swap(arr, left, pivot);
                pivot = left;
            }
            quickSort(arr, start, left - 1);
            quickSort(arr, left + 1, end);
        }
    }

    //归并排序
    private static int[] mergeSort(int[] nums) {

        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] leftArrays = Arrays.copyOfRange(nums, 0, mid);
        int[] rightArrays = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(leftArrays), mergeSort(rightArrays));
    }

    private static int[] merge(int[] leftArrays, int[] rightArrays) {
        int[] resultArr = new int[leftArrays.length + rightArrays.length];
        for (int i = 0, j = 0, k = 0; i < resultArr.length; i++) {
            if (j >= leftArrays.length) {
                resultArr[i] = rightArrays[k++];
            } else if (k >= rightArrays.length) {
                resultArr[i] = leftArrays[j++];
            } else if (leftArrays[j] < rightArrays[k]) {
                resultArr[i] = leftArrays[j++];
            } else {
                resultArr[i] = rightArrays[k++];
            }
        }
        return resultArr;
    }

    private static void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            buildMaxHeap(nums, nums.length -i);
            swap(nums, 0, nums.length - i - 1);
        }
    }

    private static void buildMaxHeap(int[] arr, int length) {
        for (int i = (length - 1 - 1) / 2; i >= 0; i--) {
            heapify(arr, i, length);
        }
    }

    private static void heapify(int[] arr, int currentNode, int length) {
        int leftChildNode = 2 * currentNode + 1;
        int rightChildNode = 2 * currentNode + 2;
        int max = currentNode;
        if (leftChildNode < length && arr[leftChildNode] > arr[max]) {
            max = leftChildNode;
        }
        if (rightChildNode < length && arr[rightChildNode] > arr[max]) {
            max = rightChildNode;
        }
        if (max != currentNode) {
            swap(arr, currentNode, max);
//            heapify(arr, max, length);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{923, 8, 7, 5, 4, 22, 456, 11, 78, 54, 12, 45, 89, 34, 23, 11, 67, 112, 11, 9, 8, 7, 2};
//        int[] ints5 = Arrays.copyOf(arr, arr.length);
//        quickSort(ints5, 0, arr.length - 1);
//        System.out.println(Arrays.toString(ints5));
//        int[] ints = mergeSort(Arrays.copyOf(arr, arr.length));
//        System.out.println(Arrays.toString(ints));
        int[] ints6 = Arrays.copyOf(arr, arr.length);
        heapSort(ints6);
        System.out.println(Arrays.toString(ints6));
    }
}
