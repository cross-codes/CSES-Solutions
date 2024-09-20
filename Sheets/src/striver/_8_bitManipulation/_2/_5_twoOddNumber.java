package striver._8_bitManipulation._2;

public class _5_twoOddNumber {
  public static int[] twoOddNum(int arr[], int n) {
    // First XOR all elements. You end up with the XOR of the two odd numbers
    int res = arr[0];
    for (int idx = 1; idx < n; idx++) res ^= arr[idx];

    // Find the rightmost bit where these differ: The result should have that bit set
    int set_bit = res & -res;

    int num1 = 0, num2 = 0;
    // Now split into groups where this bit is set:
    // The even numbers would occur in pairs, so XORing them cancels them out
    // and you only end up with one of the odd numbers, per group
    for (int idx = 0; idx < n; idx++) {
      if ((arr[idx] & set_bit) != 0) num1 ^= arr[idx];
      else num2 ^= arr[idx];
    }

    int[] ans = new int[2];
    ans[0] = Math.max(num1, num2);
    ans[1] = Math.min(num1, num2);
    return ans;
  }
}
