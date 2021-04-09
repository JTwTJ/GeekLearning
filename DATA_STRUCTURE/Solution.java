
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiangwentao
 * @date 2021/3/14
 */
public class Solution {

    public static void main(String[] args) {
//        Scanner in1 = new Scanner(System.in);
//        Integer count = in1.nextInt();
//        Scanner in2 = new Scanner(System.in);
//        List<Integer> integers = new ArrayList<>();
//        while (in2.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            integers.add(in2.nextInt());
//        }
        int count = 5;
        Integer[] integers = new Integer[]{1, 1, 2, 22, 23};
        Integer solution = solution(count, integers);
        System.out.println(solution);
    }

    public static Integer solution(Integer count, Integer[] integers) {

//        Integer[] arr = new Integer[]{};
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger totalCount = new AtomicInteger(0);
//        integers.forEach(e -> {
//            arr[atomicInteger.getAndIncrement()] = e;
//        });
        for (int i = 0; i < integers.length; i++) {
            int sum = 0;
            while (sum < 24) {
                for (int j = i; j < integers.length; j++) {
                    sum = sum + integers[j];
                    if (sum == 24) {
                        totalCount.incrementAndGet();
                        break;
                    }
                }

            }
        }
        return totalCount.get();
    }
}
