package striver._4_binarySearch._2;

public class _6_shipWithinDDays {
  static int sumOfArr(int[] arr, int len) {
    int ans = 0;
    for (int idx = 0; idx < len; idx++) ans += arr[idx];
    return ans;
  }

  static int minOfArr(int[] arr, int len) {
    int ans = Integer.MAX_VALUE;
    for (int idx = 0; idx < len; idx++) if (arr[idx] < ans) ans = arr[idx];
    return ans;
  }

  static int reqDays(int[] arr, int weightCapacity) {
    int ans = 1, load = 0, n = arr.length;
    for (int idx = 0; idx < n; idx++) {
      if (load + arr[idx] > weightCapacity) {
        ans++;
        load = arr[idx];
      } else load += arr[idx];
    }
    return ans;
  }

  public static int shipWithinDays(int[] weights, int days) {
    int L = minOfArr(weights, weights.length), R = sumOfArr(weights, weights.length), m;
    while (L <= R) {
      m = (L + R) / 2;
      if (reqDays(weights, m) <= days) R = m - 1;
      else L = m + 1;
    }
    return L;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 1, 1};
    System.err.println(reqDays(arr, 3));
  }
}
