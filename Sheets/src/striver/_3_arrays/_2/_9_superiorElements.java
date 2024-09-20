package striver._3_arrays._2;

import java.util.ArrayList;
import java.util.List;

public class _9_superiorElements {
  public static List<Integer> superiorElements(int[] arr) {
    List<Integer> ans = new ArrayList<>();
    int len = arr.length, max = Integer.MIN_VALUE;
    for (int idx = len - 1; idx >= 0; idx--) {
      if (arr[idx] > max) {
        ans.add(arr[idx]);
        max = arr[idx];
      }
    }
    return ans;
  }
}
