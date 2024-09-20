package striver._4_binarySearch._2;

public class _3_kokoEatingBananas {
  static int totalHours(int[] arr, int k) {
    int ans = 0;
    for (int idx = 0; idx < arr.length; idx++) ans += Math.ceil((double) arr[idx] / (double) k);
    return ans;
  }

  public static int minEatingSpeed(int[] piles, int h) {
    // Find the maximum and minimum in piles
    int max = Integer.MIN_VALUE, n = piles.length;
    for (int idx = 0; idx < n; idx++) {
      if (piles[idx] > max) max = piles[idx];
    }

    // Perform a BS from min to max satisfying the criteria
    // If it is indeed satisfied, we want to go eliminating right halves
    int L = 1, R = max, m;
    while (L <= R) {
      m = (L + R) / 2;
      if (totalHours(piles, m) <= h) R = m - 1;
      else L = m + 1;
    }
    return L;
  }
}
