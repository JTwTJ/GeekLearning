
import java.util.Arrays;

/**
 * 常用算法
 * <p>
 * 排序算法参考链接： https://www.cnblogs.com/onepixel/articles/7674659.html
 * 稳定：     如果a原本在b前面，而a=b，排序之后a仍然在b的前面。
 * 不稳定：   如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。
 * 时间复杂度：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。
 * 空间复杂度：是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。
 *
 * @author jiangwentao
 * @date 2021/3/11
 */
public class BaseAlgorithm {

    /**
     * 二分查找算法
     */
    private static int binarySearch(int data, int[] sortArr) {
        if (data < sortArr[0] || data > sortArr[sortArr.length - 1]) {
            throw new RuntimeException("暂无匹配数据");
        }
        int start = 0;
        int end = sortArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data == sortArr[mid]) {
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
     * 平均时间复杂度：O(n²)  最好情况：O(n) 最坏情况：O(n²) 空间复杂度：O(1) 稳定
     */
    private static int[] bubbleSort(int[] arr) {
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
     * 平均时间复杂度：O(n²)  最好情况：O(n²) 最坏情况：O(n²) 空间复杂度：O(1) 不稳定
     */
    private static int[] pickSort(int[] arr) {
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
     * 插入排序--倒序不够友好
     * 平均时间复杂度：O(n²)  最好情况：O(n) 最坏情况：O(n²) 空间复杂度：O(1) 稳定
     */
    private static int[] insertSort(int[] arr) {
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
     * 希尔排序--缩小增量排序
     * 插入排序的一种更高效的改进版本、不稳定排序算法
     * 平均时间复杂度：O(n^1.3)  最好情况：O(n) 最坏情况：O(n²) 空间复杂度：O(1) 不稳定
     */
    public static int[] shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        //这里取最大增量为数组长度的一半
        for (int decresment = arr.length / 2; decresment > 0; decresment = decresment / 2) {
            System.out.println("增量取值为：" + decresment);
            for (int i = decresment; i < arr.length; i++) {
                for (int j = i - decresment; j >= 0; j = j - decresment) {
                    if (arr[j] > arr[j + decresment]) {
                        int temp = arr[j];
                        arr[j] = arr[j + decresment];
                        arr[j + decresment] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     * 平均时间复杂度：O(nlog2n)  最好情况：O(nlog2n) 最坏情况：O(n²) 空间复杂度：O(log2n) 不稳定
     */
    private static void quickSort(int[] arr, int left, int right) {
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
     * 归并排序
     * 平均时间复杂度：O(nlog2n)  最好情况：O(nlog2n) 最坏情况：O(nlog2n) 空间复杂度：O(n) 稳定
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        //将数组对半划分
        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    /**
     * 归并排序
     */
    private static int[] merge(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            //如果左数组取完了，那么直接遍历右数组取值
            if (i >= leftArr.length) {
                result[index] = rightArr[j++];
            }
            //如果右数组取完了，那么直接遍历左数组取值
            else if (j >= rightArr.length) {
                result[index] = leftArr[i++];
            }
            //都还没取完，那么左右数组的游标值进行比较，小的塞进result
            else if (leftArr[i] > rightArr[j]) {
                result[index] = rightArr[j++];
            } else {
                result[index] = leftArr[i++];
            }
        }
        return result;
    }

    /**
     * 堆排序
     * 平均时间复杂度：O(nlog2n)  最好情况：O(nlog2n) 最坏情况：O(nlog2n) 空间复杂度：O(1) 稳定
     */
    public static void heapSort(int[] completeBinaryTree) {
        for (int i = completeBinaryTree.length; i > 0; i--) {
            buildMaxHeap(completeBinaryTree, i);
            //此时堆顶已是最大值，并将堆顶元素与当前数组最后一个元素进行交换
            swap(completeBinaryTree, 0, i - 1);
        }
    }

    /**
     * 构建大根堆
     *
     * @param needToBuildHeap 需要构建的堆
     * @param length          堆长度
     */
    private static void buildMaxHeap(int[] needToBuildHeap, int length) {
        for (int i = (length - 1) / 2; i >= 0; i--) {
            heapify(needToBuildHeap, i, length);
        }
    }

    /**
     * 局部堆化-二叉堆下沉sink
     *
     * @param currentHeap       当前小堆
     * @param needToHeapifyNode 当前需要堆化的父节点
     * @param length            堆长度
     */
    private static void heapify(int[] currentHeap, int needToHeapifyNode, int length) {
        if (needToHeapifyNode >= length) {
            return;
        }
        int max = needToHeapifyNode;
        int leftChild = 2 * needToHeapifyNode + 1;
        int rightChild = 2 * needToHeapifyNode + 2;
        if (leftChild < length && currentHeap[leftChild] > currentHeap[max]) {
            max = leftChild;
        }
        if (rightChild < length && currentHeap[rightChild] > currentHeap[max]) {
            max = rightChild;
        }
        if (max != needToHeapifyNode) {
            swap(currentHeap, max, needToHeapifyNode);
            heapify(currentHeap, max, length);
        }
    }

    /**
     * 交换值
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        //二分查找
        int[] sortArr = new int[]{1, 3, 5, 6, 8, 9, 16};
        int position = binarySearch(6, sortArr);
        System.out.println(position);

        int[] arr = new int[]{9, 8, 7, 5, 4, 22, 456, 11, 78, 54, 12, 45, 89, 34, 23, 11, 67, 112, 11, 9, 8, 7, 2};
        //冒泡排序
        int[] ints1 = bubbleSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints1));
        //选择排序
        int[] ints2 = pickSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints2));
        //插入排序
        int[] ints3 = insertSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints3));
        //希尔排序
        int[] ints4 = shellSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints4));
        //快速排序
        int[] quickSortArr = Arrays.copyOf(arr, arr.length);
        quickSort(quickSortArr, 0, arr.length - 1);
        System.out.println(Arrays.toString(quickSortArr));
        //归并排序
        int[] ints5 = mergeSort(Arrays.copyOf(arr, arr.length));
        System.out.println(Arrays.toString(ints5));
        //堆排序
        int[] heapSortArr = Arrays.copyOf(arr, arr.length);
        heapSort(heapSortArr);
        System.out.println(Arrays.toString(heapSortArr));
    }
}
