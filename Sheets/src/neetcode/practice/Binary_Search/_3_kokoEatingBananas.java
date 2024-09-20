package neetcode.practice.Binary_Search;

import java.util.Arrays;

public class _3_kokoEatingBananas {
  static int totalTime(int[] piles, int rate, int n) {
    int ans = 0;
    for (int i = 0; i < n; i++) ans += Math.ceil((double) piles[i] / rate);
    return ans;
  }

  public static int minEatingSpeed(int[] piles, int h) {
    int l = 1;
    int r = Arrays.stream(piles).max().getAsInt();
    int ans = r, n = piles.length;

    while (l <= r) {
      int m = (l + r) / 2;
      if (totalTime(piles, m, n) <= h) {
        ans = m;
        r = m - 1;
      } else l = m + 1;
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] piles = {25, 10, 23, 4};
    System.out.println(minEatingSpeed(piles, 4));
  }
}
