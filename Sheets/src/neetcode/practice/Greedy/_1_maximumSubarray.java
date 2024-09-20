package neetcode.practice.Greedy;

public class _1_maximumSubarray {
  public static int maxSubArray(int[] nums) {
    int currSum = 0;
    int bestSum = Integer.MIN_VALUE;

    for (int num : nums) {
      currSum = Math.max(num, num + currSum);
      bestSum = Math.max(currSum, bestSum);
    }

    return bestSum;
  }
}
