package neetcode.practice.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class _2_longestSubstringWithoutDuplicates {
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;

    int n = s.length();
    if (n == 1) return 1;

    int ans = 1;
    int l = 0, r = 1;
    Map<Character, Integer> map = new HashMap<>();

    while (r < n) {
      if (map.isEmpty()) map.put(s.charAt(l), l);

      char rc = s.charAt(r);
      if (map.containsKey(rc)) {
        ans = Math.max(ans, r - l);
        int repeatIndex = map.get(rc);
        for (int i = l; i <= repeatIndex; i++) map.remove(s.charAt(i));
        l = repeatIndex + 1;
        map.put(rc, r);
        r++;
      } else {
        map.put(rc, r);
        r++;
      }
    }

    ans = Math.max(ans, r - l);

    return ans;
  }
}
