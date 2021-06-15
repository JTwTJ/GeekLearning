import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author jiangwentao
 * @date 2021/6/15
 * @detail
 */
public class Solution460 {


    static class LFUCache {

        private final HashMap<Integer, Integer> keyValMap;
        private final HashMap<Integer, LinkedHashSet<Integer>> freqKeyMap;
        private final HashMap<Integer, Integer> keyFreqMap;
        private final int capacity;
        private int minFreq;

        public LFUCache(int capacity) {
            this.keyValMap = new HashMap<>();
            this.freqKeyMap = new HashMap<>();
            this.keyFreqMap = new HashMap<>();
            this.capacity = capacity;
            this.minFreq = 0;
        }

        public int get(int key) {
            if (!keyValMap.containsKey(key)) {
                return -1;
            }
            increaseFreq(key);
            return keyValMap.get(key);
        }

        private void increaseFreq(int key) {
            Integer freq = keyFreqMap.getOrDefault(key, 0);
            keyFreqMap.put(key, freq + 1);
            if (freq != 0) {
                LinkedHashSet<Integer> oldKeySet = freqKeyMap.get(freq);
                oldKeySet.remove(key);
                if (oldKeySet.isEmpty()) {
                    freqKeyMap.remove(freq);
                    if (minFreq == freq) {
                        this.minFreq++;
                    }
                }
            }
            LinkedHashSet<Integer> newKeySet = freqKeyMap.getOrDefault(freq + 1, new LinkedHashSet<>());
            newKeySet.add(key);
            freqKeyMap.put(freq + 1, newKeySet);
        }

        private void removeMinFreqKey() {
            LinkedHashSet<Integer> ketSet = freqKeyMap.get(minFreq);
            Integer deleteKey = ketSet.iterator().next();
            keyValMap.remove(deleteKey);
            keyFreqMap.remove(deleteKey);
            ketSet.remove(deleteKey);
            if (ketSet.isEmpty()) {
                freqKeyMap.remove(minFreq);
            }
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            if (keyValMap.containsKey(key)) {
                keyValMap.put(key, value);
                increaseFreq(key);
                return;
            }
            if (capacity <= keyValMap.size()) {
                //移除最小使用并且最近未使用
                removeMinFreqKey();
            }
            keyValMap.put(key, value);
            minFreq = 1;
            increaseFreq(key);
        }
    }

    public static void main(String[] args) {
        Solution460 solution460 = new Solution460();
        Solution460.LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(3, 1);
        lfuCache.put(2, 1);
        lfuCache.put(2, 2);
        lfuCache.put(4, 4);
        lfuCache.get(2);
    }
}
