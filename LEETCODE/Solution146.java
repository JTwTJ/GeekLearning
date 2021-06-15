import java.util.LinkedHashMap;

/**
 * @author jiangwentao
 * @date 2021/6/13
 * @detail LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution146 {

    static class LRUCache {

//        private Map<Integer, Node> dic;
//        private int capacity;
//        private DoubleList cache;
//
//        public LRUCache(int capacity) {
//            this.capacity = capacity;
//            this.dic = new HashMap<>();
//            this.cache = new DoubleList();
//        }
//
//        private void makeRecently(int key) {
//            Node x = dic.get(key);
//            cache.removeNode(x);
//            cache.addLast(x);
//        }
//
//        private void addRecently(int key, int val) {
//            Node x = new Node(key, val);
//            cache.addLast(x);
//            dic.put(key, x);
//        }
//
//        private void deleteKey(int key) {
//            Node x = dic.get(key);
//            cache.removeNode(x);
//            dic.remove(key);
//        }
//
//        private void removeLeastRecenly() {
//            Node x = cache.removeFirst();
//            dic.remove(x.key);
//        }
//
//        public int get(int key) {
//            if (!dic.containsKey(key)) {
//                return -1;
//            }
//            Node x = dic.get(key);
//            makeRecently(key);
//            return x.val;
//        }
//
//        public void put(int key, int value) {
//            if (dic.containsKey(key)) {
//                deleteKey(key);
//                addRecently(key, value);
//                return;
//            }
//            if (capacity == cache.size) {
//                removeLeastRecenly();
//            }
//            addRecently(key, value);
//        }
//    }
//
//    static class Node {
//        int key;
//        int val;
//        Node pre;
//        Node next;
//
//        public Node(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
//
//    static class DoubleList {
//        Node head;
//        Node tail;
//        int size;
//
//        public DoubleList() {
//            this.head = new Node(0, 0);
//            this.tail = new Node(0, 0);
//            head.pre = tail;
//            tail.next = head;
//            this.size = 0;
//        }
//
//        private void addLast(Node x) {
//            x.pre = tail;
//            x.next = tail.next;
//            tail.next.pre = x;
//            tail.next = x;
//            size++;
//        }
//
//        private void removeNode(Node x) {
//            x.next.pre = x.pre;
//            x.pre.next = x.next;
//            size--;
//        }
//
//        private Node removeFirst() {
//            if (head.pre == tail) {
//                return null;
//            }
//            Node first = head.pre;
//            removeNode(first);
//            return first;
//        }
//
//        // 返回链表长度，时间 O(1)
//        public int size() {
//            return size;
//        }

        private LinkedHashMap<Integer, Integer> cache;
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            Integer val = cache.remove(key);
            cache.put(key, val);
            return val;
        }

        public void put(int key, int val) {
            if (cache.containsKey(key)) {
                cache.remove(key);
                cache.put(key, val);
                return;
            }
            if (cache.size() >= capacity) {
                Integer oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, val);
        }
    }

    public static void main(String[] args) {
        Solution146.LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        int i = cache.get(1);
        System.out.println(i);
    }
}
