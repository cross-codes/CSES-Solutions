package neetcode.practice.Linked_List;

import java.util.LinkedHashSet;
import java.util.Set;

public class _8_findDuplicateInteger {
  public static int findDuplicate(int[] nums) {
    Set<Integer> set = new LinkedHashSet<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      if ((set.contains(nums[i]))) return nums[i];
      else set.add(nums[i]);
    }

    return -1;
  }
}
