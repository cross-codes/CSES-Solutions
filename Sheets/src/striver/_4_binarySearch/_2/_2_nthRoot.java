package striver._4_binarySearch._2;

public class _2_nthRoot {
  static int power(int x, int n) {
    int ans = 1;
    for (int i = 0; i < n; i++) ans *= x;
    return ans;
  }

  public static int NthRoot(int n, int m) {
    int L = 0, R = m - 1, M;
    while (L != R) {
      if ((L + R) % 2 != 0) M = (L + R) / 2 + 1;
      else M = (L + R) / 2;

      if (power(M, n) > m) R = M - 1;
      else L = M;
    }

    if (power(L, n) == m) return L;
    else return -1;
  }
}
