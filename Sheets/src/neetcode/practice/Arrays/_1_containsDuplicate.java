package neetcode.practice.Arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class _1_containsDuplicate {
  public static boolean hasDuplicate(int[] nums) {
    Set<Integer> set = new LinkedHashSet<>();
    for (int a : nums) {
      if (set.contains(a)) return true;
      else set.add(a);
    }
    return false;
  }
}
