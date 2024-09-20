package neetcode.practice.Arrays;

import java.util.Map;
import java.util.WeakHashMap;

public class _2_validAnagram {
  public static boolean isAnagram(String s, String t) {
    Map<Character, Integer> mapForS = new WeakHashMap<>();
    Map<Character, Integer> mapForT = new WeakHashMap<>();
    int n = s.length();
    if (t.length() != n) return false;
    else {
      for (int idx = 0; idx < n; idx++) {
        char c = s.charAt(idx);
        if (mapForS.containsKey(c)) {
          int freq = mapForS.get(c);
          mapForS.put(c, ++freq);
        } else {
          mapForS.put(c, 1);
        }
      }

      for (int idx = 0; idx < n; idx++) {
        char c = t.charAt(idx);
        if (mapForT.containsKey(c)) {
          int freq = mapForT.get(c);
          mapForT.put(c, ++freq);
        } else {
          mapForT.put(c, 1);
        }
      }

      return mapForS.equals(mapForT);
    }
  }
}
