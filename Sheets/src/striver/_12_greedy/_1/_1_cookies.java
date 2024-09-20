package striver._12_greedy._1;

import java.util.Arrays;

public class _1_cookies {
  public static int findContentChildren(int[] g, int[] s) {
    Arrays.sort(s);
    Arrays.sort(g);
    int count = 0, gIndex = 0, sIndex = 0;
    int gLength = g.length, sLength = s.length;

    while (true) {
      if (gIndex == gLength || sIndex == sLength) break;
      if (g[gIndex] <= s[sIndex]) {
        count++;
        gIndex++;
        sIndex++;
      } else sIndex++;
    }

    return count;
  }
}
