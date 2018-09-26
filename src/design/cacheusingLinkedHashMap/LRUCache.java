package design.cacheusingLinkedHashMap;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.map = new LinkedhashMapWithCapacity<>(capacity);
        this.map = Collections.synchronizedMap(map);
    }

    public int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) {
            value = -1;
        } else {
            this.set(key, value);
        }
        return value;
    }

    public void set(int key, int value) {
        if (this.map.containsKey(key))
            this.map.remove(key);
        this.map.get(key);
    }
}
