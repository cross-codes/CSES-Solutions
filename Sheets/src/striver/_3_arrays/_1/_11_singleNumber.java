package striver._3_arrays._1;

public class _11_singleNumber {
  public static int singleNumber(int[] arr) {
    int ans = 0, n = arr.length;
    for (int i = 0; i < n; i++) ans ^= arr[i];
    return ans;
  }
}
