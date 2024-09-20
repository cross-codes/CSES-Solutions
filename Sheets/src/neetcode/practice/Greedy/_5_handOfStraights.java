package neetcode.practice.Greedy;

import java.util.TreeMap;

public class _5_handOfStraights {
  public static boolean isNStraightHand(int[] hand, int groupSize) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int num : hand) map.put(num, map.getOrDefault(num, 0) + 1);

    while (!map.isEmpty()) {
      int i = 1, currNum = map.firstKey();
      int freq = map.get(currNum);
      if (freq == 1) map.remove(currNum);
      else map.put(currNum, --freq);

      while (i++ < groupSize) {
        currNum++;
        freq = map.getOrDefault(currNum, -1);
        switch (freq) {
          case -1:
            return false;

          case 1:
            map.remove(currNum);
            break;

          default:
            map.put(currNum, --freq);
        }
      }
    }
    return true;
  }
}
