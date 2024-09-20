package striver._4_binarySearch._1;

public class _5_ceilTheFloor {
  public static int[] getFloorAndCeil(int[] a, int n, int x) {
    int[] ans = new int[2];
    int L = 0, R = n - 1, m;
    while (L != R) {
      if ((L + R) % 2 != 0) m = (L + R) / 2 + 1;
      else m = (L + R) / 2;

      if (a[m] > x) R = m - 1;
      else L = m;
    }
    if (a[L] == x) {
      ans[0] = a[L];
      ans[1] = a[L];
    } else {
      if (L != 0) {
        if (a[L] > x) {
          ans[0] = a[L - 1];
          ans[1] = a[L];
        } else {
          ans[0] = a[L];
          ans[1] = (L != n - 1) ? a[L + 1] : -1;
        }
      }
      else {
        if (a[L] > x) {
          ans[0] = -1;
          ans[1] = a[L];
        } else {
          ans[0] = a[L];
          ans[1] = (L != n - 1) ? a[L + 1] : -1;
        }
      }
    }
    return ans;
  }
}
