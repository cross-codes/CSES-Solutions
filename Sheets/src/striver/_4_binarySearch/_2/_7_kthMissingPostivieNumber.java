package striver._4_binarySearch._2;

public class _7_kthMissingPostivieNumber {
  static int bsearch(int x, int[] arr) {
    int n = arr.length, L = 0, R = n - 1, m;
    while (L <= R) {
      m = (L + R) / 2;
      if (arr[m] < x) L = m + 1;
      else if (arr[m] > x) R = m - 1;
      else return m;
    }
    return -1;
  }

  public static int findKthPositive(int[] arr, int k) {
    int count = 0, currSearchItem = 1;
    while (true) {
      int idx = bsearch(currSearchItem, arr);
      if (idx == -1) count++;
      if (count == k) break;
      currSearchItem++;
    }
    return currSearchItem;
  }
}
