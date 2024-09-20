package neetcode.practice.Linked_List;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
  private int capacity;
  private Map<Integer, Integer> map;

  public LRUCache(int val) {
    capacity = val;
    map =
        new LinkedHashMap<>(16, 0.75f, true) {
          @Override
          protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
          }
        };
  }

  public int get(int key) {
    return map.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    map.put(key, value);
  }
}
