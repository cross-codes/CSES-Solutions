package striver._7_recursion._1;

public class _2_powerXN {
  public static double myPow(double x, int n) {
    if (n == 0) return 1.0;

    long nn = n; // Avoid overflow because negative of MIN_VALUE is out of range

    if (nn < 0) nn = -nn;

    double ans = 1.0;

    while (nn > 0) {
      if ((nn & 1) == 1) {
        ans *= x;
        nn--;
      } else {
        x *= x;
        nn >>= 1;
      }
    }

    if (n < 0) ans = 1.0 / ans;
    return ans;
  }
}
