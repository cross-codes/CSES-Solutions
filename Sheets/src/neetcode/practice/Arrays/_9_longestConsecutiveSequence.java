package neetcode.practice.Arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class _9_longestConsecutiveSequence {
  public static int longestConsecutive(int[] nums) {
    Set<Integer> set = new LinkedHashSet<>();

    for (int num : nums) set.add(num);

    int longest = 0;
    for (int n : set) {
      // Don't bother looking backwards
      // Question: Why is this O(n)?
      if (!set.contains(n - 1)) {
        int length = 1;
        // Keep checking if n, n + 1, n + 2 ... exists
        while (set.contains(n + length)) length++;
        longest = Math.max(length, longest);
      }
    }

    return longest;
  }
}
