package striver._12_greedy._2;

import java.util.Arrays;

public class _1_NMeetingsInOneRoom {
  public static int maxMeetings(int start[], int end[], int n) {
    Arrays.sort(start);
    Arrays.sort(end);
    int sIdx = 0, eIdx = 0, ans = 0;

    while (true) {
      while (sIdx < n && eIdx < n && end[eIdx] <= start[sIdx]) eIdx++;
      if (sIdx == n || eIdx == n) return ans;
      ans++;
      while (sIdx < n && eIdx < n && start[sIdx] <= end[eIdx]) sIdx++;
      if (sIdx == n || eIdx == n) return ans;
    }
  }
}
