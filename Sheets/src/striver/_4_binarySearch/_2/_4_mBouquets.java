package striver._4_binarySearch._2;

import java.util.Arrays;

public class _4_mBouquets {

  static int numOfBoquets(int[] arr, int day, int k) {
    int ans = 0, count = 0, n = arr.length;
    for (int idx = 0; idx < n; idx++) {
      while (idx < n && arr[idx] <= day) {
        count++;
        idx++;
      }
      ans += count / k;
      count = 0;
    }
    return ans;
  }

  public static int minDays(int[] bloomDay, int m, int k) {
    int n = bloomDay.length;
    // Validation step
    if ((long) m * k > n) return -1;

    int[] copy = bloomDay.clone();

    // The answer will be one of the elements of the array,
    // because waiting in between will not change any outcome.
    Arrays.sort(copy);

    int L = 0, R = n - 1, M;

    while (L < R) {
      M = (L + R) / 2;
      if (numOfBoquets(bloomDay, copy[M], k) >= m) R = M;
      else L = M + 1;
    }
    return copy[L];
  }
}
