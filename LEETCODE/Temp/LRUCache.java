package Temp;

import java.util.LinkedHashMap;

/**
 * @author jiangwentao
 * @date 2021/6/23
 * @detail
 */
public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }

    private void makeRecently(int key, int value) {
        cache.remove(key);
        cache.put(key, value);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if (capacity == cache.size()) {
            int oldestKey = cache.keySet().stream().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }
}
