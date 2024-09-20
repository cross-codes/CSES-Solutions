package striver._8_bitManipulation._2;

import java.util.ArrayList;
import java.util.List;

public class _3_powerset {
  public static List<List<Integer>> subsets(int[] nums) {
    long n = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < (1 << n); i++) {
      List<Integer> subset = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        // If the corresponding bit is set, add that index
        if ((i & (1 << j)) != 0) {
          subset.add(nums[j]);
        }
      }
      ans.add(subset);
    }

    return ans;
  }
}
