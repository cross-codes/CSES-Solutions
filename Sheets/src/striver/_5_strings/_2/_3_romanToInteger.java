package striver._5_strings._2;

import java.util.HashMap;
import java.util.Map;

public class _3_romanToInteger {
  public static int romanToInt(String s) {
    int ans = 0, n = s.length();

    // Initialization
    Map<Character, Integer> equiv = new HashMap<Character, Integer>();
    equiv.put('I', 1);
    equiv.put('V', 5);
    equiv.put('X', 10);
    equiv.put('L', 50);
    equiv.put('C', 100);
    equiv.put('D', 500);
    equiv.put('M', 1000);

    for (int idx = n - 1; idx > -1; idx--) {
      char c = s.charAt(idx);
      char next = (idx == n - 1) ? ' ' : s.charAt(idx + 1);
      if (idx != n - 1
          && ((c == 'I' && (next == 'V' || next == 'X'))
              || (c == 'X' && (next == 'L' || next == 'C'))
              || (c == 'C' && (next == 'D' || next == 'M')))) ans -= equiv.get(c);
      else ans += equiv.get(c);
    }
    return ans;
  }
}
