package striver._4_binarySearch._2;

public class _1_squareRoot {
  public static long floorSqrt(long x) {
    if (x == 1) return 1;
    long L = 0, R = x - 1, m;
    while (L != R) {
      if ((L + R) % 2 != 0) m = (L + R) / 2 + 1;
      else m = (L + R) / 2;

      if (m * m > x) R = m - 1;
      else L = m;
    }
    return L;
  }
}
