package striver._3_arrays._2;

public class _5_maximumSubarrayLength {
  public static int longestSubarrayWithSumK(int[] a, long k) {
    int arrLength = a.length, left = 0, right = 0;
    long sum = a[0];
    int maxLen = 0;

    while (right < arrLength) {
      while (left <= right && sum > k) {
        sum -= a[left];
        left++;
      }
      if (sum == k) maxLen = Math.max(maxLen, right - left + 1);
      right++;
      if (right < arrLength) sum += a[right];
    }
    return maxLen;
  }
}
