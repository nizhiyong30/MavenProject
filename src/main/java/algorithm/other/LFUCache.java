package algorithm.other;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author nizy
 * @date 2021/4/6 9:39 上午
 */
public class LFUCache {
    private HashMap<Integer, Integer> keyToVal = new HashMap<>();
    private HashMap<Integer, Integer> keyToFreq = new HashMap<>();
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();
    private int capacity;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increase(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity <= 0) return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increase(key);
            return;
        }
        if (keyToVal.size() >= capacity) {
            remove();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFrequency = 1;
    }


    public void increase(int key) {
        int frequency = keyToFreq.get(key);
        keyToFreq.put(key, frequency + 1);
        freqToKeys.get(frequency).remove(key);
        freqToKeys.putIfAbsent(frequency + 1, new LinkedHashSet<>());
        freqToKeys.get(frequency + 1).add(key);
        if (freqToKeys.get(frequency).size() == 0) {
            freqToKeys.remove(frequency);
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }
    }

    public void remove() {
        LinkedHashSet<Integer> keys = freqToKeys.get(minFrequency);
        Integer removeKey = keys.iterator().next();
        keys.remove(removeKey);
        if (keys.size() == 0) {
            freqToKeys.remove(minFrequency);
        }
        keyToVal.remove(removeKey);
        keyToFreq.remove(removeKey);
    }
}
