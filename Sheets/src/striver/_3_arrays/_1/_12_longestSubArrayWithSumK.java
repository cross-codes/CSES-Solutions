package striver._3_arrays._1;

public class _12_longestSubArrayWithSumK {
  public static int longestSubarrayWithSumK(int[] a, long k) {
    int arrLength = a.length, left = 0, right = 0;
    long sum = a[0];
    int maxLen = 0;

    while (right < arrLength) {
      // Keep increasing right index and sum ; however

      // If the sum > k, reduce the subarray from the left
      while (left <= right && sum > k) {
        sum -= a[left];
        left++;
      }

      // If the sum = k, update our maximum length
      if (sum == k) maxLen = Math.max(maxLen, right - left + 1);

      right++;

      // Update only if the condition isn't inherently broken
      if (right < arrLength) sum += a[right];
    }
    return maxLen;
  }
}
