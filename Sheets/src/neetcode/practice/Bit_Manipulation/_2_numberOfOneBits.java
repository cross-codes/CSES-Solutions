package neetcode.practice.Bit_Manipulation;

public class _2_numberOfOneBits {
  public static int hammingWeight(int n) {
    int cnt = 0;
    for (int i = 0; i < 32; i++) if (((1 << i) & n) != 0) cnt++;
    return cnt;
  }
}
