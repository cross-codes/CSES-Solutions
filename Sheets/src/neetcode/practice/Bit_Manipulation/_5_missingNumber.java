package neetcode.practice.Bit_Manipulation;

public class _5_missingNumber {
  public static int missingNumber(int[] nums) {
    int ans = 0, n = nums.length;
    for (int i = 1; i <= n; i++) ans ^= i;
    for (int i = 0; i < n; i++) ans ^= nums[i];
    return ans;
  }
}
