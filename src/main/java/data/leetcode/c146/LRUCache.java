package data.leetcode.c146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
            return super.get(key) == null ? -1 : super.get(key);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        System.out.println(cache); // 输出: {1=One, 2=Two, 3=Three}

        cache.get(1); // 更新最近访问的条目

        cache.put(4, 4); // 插入新条目，触发LRU策略删除最老的条目

        System.out.println(cache); // 输出: {2=Two, 3=Three, 4=Four}
    }
}
