package striver._8_bitManipulation._1;

public class _8_division {
  public static int divide(int dividend, int divisor) {
    // n << k == n * 2 ^ (k)
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    if (dividend == divisor) return 1;

    boolean isPositive = (dividend < 0 == divisor < 0);
    long a = Math.abs((long) dividend);
    long b = Math.abs((long) divisor);
    int ans = 0;

    while (a >= b) {
      int q = 0;
      while (a >= (b << (q + 1))) q++;
      ans += (1 << q); // Power of 2
      a = a - (b << q); // Reduce dividend
    }
    // Once this loop ends, there is the remainder portion that
    // is neglected because of the truncated division
    return isPositive ? ans : -ans;
  }
}
