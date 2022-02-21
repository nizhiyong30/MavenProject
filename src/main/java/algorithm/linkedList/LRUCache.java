package algorithm.linkedList;

import java.util.LinkedHashMap;

/**
 * @author nizy
 * @date 2021/12/14 10:45 下午
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> linkedHashMap;
    private int capacity;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!linkedHashMap.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return linkedHashMap.get(key);
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.put(key, value);
            makeRecently(key);
            return;
        }
        if(linkedHashMap.size() >= capacity) {
            int deleteKey = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(deleteKey);
        }
        linkedHashMap.put(key, value);
    }

    public void makeRecently(int key) {
        Integer value = linkedHashMap.get(key);
        if (value != null) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
        }
    }
}
