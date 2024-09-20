package neetcode.practice.Math_And_Geometry;

public class _6_powXN {
  public static double myPow(double x, int n) {
    double res = 1.0;
    if (n > 0) {
      for (int i = 0; i < n; i++) res *= x;
    } else if (n < 0) {
      for (int i = 0; i < -n; i++) res *= 1.0 / x;
    }
    return res;
  }
}
