package striver._3_arrays._2;

public class _14_subArrayWithGivenSum {
  public static int subarraySumBad(int[] nums, int k) {
    int len = nums.length, ans = 0;
    int[] sums = new int[len + 1];
    // First obtain all possible sum(0, n)
    for (int idx = 0, i = 1; idx < len; idx++, i++)
      for (int sidx = 0; sidx <= idx; sidx++) sums[i] += nums[sidx];

    // Now find the total number of combinations of sums that differ to k
    // sum(i, j) = sum (0, j) - sum (0, i) ; i < j
    for (int start = 0; start < len + 1; start++)
      for (int end = len; end > start; end--) if (sums[end] - sums[start] == k) ans++;

    return ans;
  }
}
