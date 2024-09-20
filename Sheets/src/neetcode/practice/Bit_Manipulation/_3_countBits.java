package neetcode.practice.Bit_Manipulation;

public class _3_countBits {
  public static int[] countBits(int n) {
    int upperLimit = (int) Math.ceil(Math.log(n) / Math.log(2));
    int[] ans = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      int cnt = 0;
      for (int j = 0; j <= upperLimit; j++) if (((1 << j) & i) != 0) cnt++;
      ans[i] = cnt;
    }
    return ans;
  }
}
