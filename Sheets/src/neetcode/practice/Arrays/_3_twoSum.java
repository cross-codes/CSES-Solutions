package neetcode.practice.Arrays;

import java.util.Map;
import java.util.WeakHashMap;

public class _3_twoSum {
  public static int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    Map<Integer, Integer> map = new WeakHashMap<>();
    int n = nums.length;

    for (int idx = 0; idx < n; idx++) {
      int num = nums[idx];
      if (map.containsKey(target - num)) {
        int otherIdx = map.get(target - num);
        if (otherIdx != idx) {
          ans[0] = Math.min(idx, otherIdx);
          ans[1] = Math.max(idx, otherIdx);
        }
      } else map.put(num, idx);
    }

    return ans;
  }
}
