package neetcode.practice.Arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _5_topKElementsInList {
  public static int[] topKFrequent(int[] nums, int k) {
    int n = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int idx = 0; idx < n; idx++) {
      int num = nums[idx];
      if (map.containsKey(num)) {
        int freq = map.get(num);
        map.put(num, ++freq);
      } else map.put(num, 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> queue =
        new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    queue.addAll(map.entrySet());

    int[] ans = new int[k];
    while (k-- > 0) {
      Map.Entry<Integer, Integer> entry = queue.poll();
      ans[k] = entry.getKey();
    }

    return ans;
  }
}
