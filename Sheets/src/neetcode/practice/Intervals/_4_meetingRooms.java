package neetcode.practice.Intervals;

import java.util.Comparator;
import java.util.List;

class Interval {
  public int start, end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class _4_meetingRooms {
  public static boolean canAttendMeetings(List<Interval> intervals) {
    intervals.sort(
        new Comparator<Interval>() {
          @Override
          public int compare(Interval a, Interval b) {
            if (a.end <= b.start) return -1;
            else return 1;
          }
        });
    int n = intervals.size();

    for (int i = 1; i < n; i++) {
      if (intervals.get(i).start < intervals.get(i - 1).end) return false;
    }

    return true;
  }
}
