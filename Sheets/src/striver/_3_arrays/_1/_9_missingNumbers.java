package striver._3_arrays._1;

public class _9_missingNumbers {
  public static int missingNumber(int[] nums) {
    int sum = 0, n = nums.length;
    for (int i = 0; i < n; i++) sum += nums[i];
    return (n * (n + 1) / 2) - sum;
  }
}
