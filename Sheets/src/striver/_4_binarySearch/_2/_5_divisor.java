package striver._4_binarySearch._2;

public class _5_divisor {
  static int sum(int[] arr, int element) {
    int ans = 0, n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] % element != 0) ans += (arr[i] / element) + 1;
      else ans += arr[i] / element;
    }
    return ans;
  }

  public static int smallestDivisor(int[] nums, int threshold) {
    int max = Integer.MIN_VALUE, n = nums.length;
    for (int idx = 0; idx < n; idx++) if (nums[idx] > max) max = nums[idx];
    int L = 1, R = max, m;
    while (L <= R) {
      m = (L + R) / 2;
      if (sum(nums, m) <= threshold) R = m - 1;
      else L = m + 1;
    }
    return L;
  }
}
