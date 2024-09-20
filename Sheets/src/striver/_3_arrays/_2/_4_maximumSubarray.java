package striver._3_arrays._2;

/**
 * Subarray with the largest sum
 *
 * First traverse the array in a single direction.
 * Start by maintaining a maximum sum value, that is 
 * continually updated if the current sum is larger than
 * it. In case the sum goes to a number lesser than zero,
 * we would not want to include any subarrays that have these
 * previous elements that sum up to < 0.
 *
 * In such a case, reset the sum to zero, but the maximum sum
 * stays as is, unless the new sum adds up to a number greater than
 * it. This method works because we are only allowed to choose
 * a contiguous subarray, so by discarding the previous trail,
 * we are choosing a subarray whose sum is not reduced by it's
 * head.
 */
public class _4_maximumSubarray {
  public static int maxSubArray(int[] nums) {
    int maximumSum = Integer.MIN_VALUE, sum = 0;
    for (int var : nums) {
      sum += var;
      if (sum >= maximumSum) maximumSum = sum;
      if (sum < 0) sum = 0;
    }
    return maximumSum;
  }
}
