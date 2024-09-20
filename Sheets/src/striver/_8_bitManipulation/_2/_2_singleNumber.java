package striver._8_bitManipulation._2;

public class _2_singleNumber {
  // XOR on a series of numbers is independent of their order
  // XOR of the same number even times is zero
  // XOR of the same number odd times is the number itself
  public static int singleNumber(int[] arr) {
    int ans = arr[0], n = arr.length;
    for (int i = 1; i < n; i++) ans ^= arr[i];
    return ans;
  }
}
