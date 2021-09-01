import java.util.Arrays;

/**
 * @author jiangwentao
 * @date 2021/4/27
 * @detail 手写常规算法
 */
public class SelfMadeAlgorithm {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //冒泡排序
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    //选择排序
    public static int[] chooseSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    //插入排序
    public static int[] insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    //希尔排序
    public static int[] shellSort(int[] arr) {

        if (arr.length < 2) {
            return arr;
        }
        for (int decrease = arr.length / 2; decrease >= 1; decrease /= 2) {
            System.out.println("增量为：" + decrease);
            for (int i = decrease; i < arr.length; i++) {
                for (int j = i - decrease; j >= 0; j -= decrease) {
                    if (arr[j] > arr[j + decrease]) {
                        swap(arr, j, j + decrease);
                    } else {
                        break;
                    }
                }
            }
        }
        return arr;
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
        int[] arr = new int[]{9, 8, 7, 5, 4, 22, 456, 11, 78, 54, 12, 45, 89, 34, 23, 11, 67, 112, 11, 9, 8, 7, 2};
        //冒泡排序
        int[] ints1 = bubbleSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints1));
        //选择排序
        int[] ints2 = chooseSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints2));
        //插入排序
        int[] ints3 = insertSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints3));
        //希尔排序
        int[] ints4 = shellSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints4));
        //快速排序
        int[] ints5 = Arrays.copyOf(arr, arr.length);
        quickSort(ints5, 0, ints5.length);
        System.out.println(Arrays.toString(ints5));
        int[] ints6 = Arrays.copyOf(arr, arr.length);
        heapSort(ints6);
        System.out.println(Arrays.toString(ints6));
    }

    public void heapSort1(int[] nums) {
        for (int i = nums.length; i > 0; i++) {
            buildMaxHeap1(nums, i);
            swap(nums, 0, i -1);
        }
    }

    private void buildMaxHeap1(int[] nums, int length) {

        for (int i = (length - 1) / 2; i >= 0; i--) {
            heapify1(nums, i, length);
        }
    }

    private void heapify1(int[] nums, int currentNode, int length) {

        int leftChi = currentNode * 2 + 1;
        int rightChi = currentNode * 2 + 2;
        int max = currentNode;
        if (nums[max] < nums[leftChi]) {
            max = leftChi;
        }
        if (nums[max] < nums[rightChi]) {
            max = rightChi;
        }
        if (max != currentNode) {
            swap(nums, max, currentNode);
            heapify1(nums, max, length);
        }
    }
}
