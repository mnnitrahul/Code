package design.cacheusingLinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedhashMapWithCapacity<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    public LinkedhashMapWithCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > this.capacity;
    }
}
