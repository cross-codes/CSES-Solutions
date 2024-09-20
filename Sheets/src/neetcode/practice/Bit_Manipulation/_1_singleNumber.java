package neetcode.practice.Bit_Manipulation;

public class _1_singleNumber {
  public static int singleNumber(int[] nums) {
    int ans = nums[0], n = nums.length;
    for (int i = 1; i < n; i++) ans ^= nums[i];
    return ans;
  }
}
