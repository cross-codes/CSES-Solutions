package neetcode.practice.Intervals;

import java.util.Arrays;

public class _3_nonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 1) return 0;

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    int cnt = 0;
    int prevEnd = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];
      if (start >= prevEnd) {
        prevEnd = end;
      } else {
        cnt++;
        prevEnd = Math.min(end, prevEnd);
      }
    }
    return cnt;
  }
}
