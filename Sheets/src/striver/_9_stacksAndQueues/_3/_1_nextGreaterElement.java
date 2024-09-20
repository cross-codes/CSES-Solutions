package striver._9_stacksAndQueues._3;

import java.util.HashMap;

public class _1_nextGreaterElement {
  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int n = nums1.length, N = nums2.length;
    int[] ans = new int[n];

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < N; i++) map.put(nums2[i], i);

    for (int j = 0; j < n; j++) {
      int st = map.get(nums1[j]);
      boolean added = false;
      for (; st < N; st++) {
        if (nums2[st] > nums1[j]) {
          added = true;
          ans[j] = nums2[st];
          break;
        }
      }
      if (!added) ans[j] = -1;
    }

    return ans;
  }
}
