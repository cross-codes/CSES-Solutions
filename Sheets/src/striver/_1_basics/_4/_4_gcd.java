package striver._1_basics._4;

public class _4_gcd {
  // GCD of a, b is denoted by (a, b) throughout
  public static int calcGCD(int n, int m) {
    // End result: (0, v) = v
    if (n == 0) return m;
    else if (m == 0) return n;

    // Find the greatest power of 2 common to m and n
    int twoPower = 0;
    // Check if the LSB (& 1) of both (|) m or n is 0 (i.e even)
    for (; ((m | n) & 1) == 0; twoPower++) {
      m >>= 1; // Divide by 2
      n >>= 1;
    }

    // At this point, n has been stripped of all factors
    // of two that are common to m and n

    // Remove common factors of 2 from m
    while ((m & 1) == 0) m >>= 1;

    // Euclidean algorithm
    while (n != 0) {
      // Continually divide by two if even
      while ((n & 1) == 0) n >>= 1;

      // Swap
      if (m > n) {
        m = m ^ n;
        n = m ^ n;
        m = m ^ n;
      }

      // (u, v) = (u, v-u) if u and v are odd
      n -= m;
    }

    return m << twoPower;
  }
}
