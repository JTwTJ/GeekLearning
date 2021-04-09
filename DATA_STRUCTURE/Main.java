
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author jiangwentao
 * @date 2021/3/24
 */
public class Main {

    public static void main(String[] args) {
    }

//    private static Integer[] result(Integer[] arr) {
//
//        int max = 0;
//        int start = 0;
//        int end = 0;
//        int sum = 0;
//        for(int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                sum = sum + arr[j];
//                if (sum > max) {
//                    max = sum;
//                    start = i;
//                    end = j;
//                }
//            }
//        }
//        Integer[] result = new Integer[end - start + 1];
//        int temp = start;
//        for (int i = 0; i <= end - start; i++) {
//            result[i] = arr[temp];
//            temp++;
//        }
//        return result;
//    }

    class Node {
        private int id;

        private long timeValue;

        private List<Node> parentNodeList;

        private List<Node> childNodeList;

        private Boolean done;
    }

    public static long time = 0L;

    public static void result(List<Node> nodeList) {
        List<Node> nodes = nodeList.stream().filter(e -> e.parentNodeList == null)
                .collect(Collectors.toList());
        startWork(nodes);
        System.out.println(time);
    }

    private static void startWork(List<Node> nodes) {

        time = time + nodes.get(0).timeValue;
        List<Node> childNodes = nodes.stream().filter(e -> e.childNodeList != null)
                .collect(Collectors.toList());
        if (childNodes == null) {
            return;
        }
        startWork(childNodes);
    }

    private static void addTime(List<Node> parentNodeList, AtomicLong totalTime) {
        if (parentNodeList == null) {
            return;
        }
        parentNodeList.forEach(node -> {
            if (node.parentNodeList == null) {
                totalTime.addAndGet(node.timeValue);
                node.done = Boolean.TRUE;
            }
            addTime(node.parentNodeList, totalTime);
        });
    }
}
