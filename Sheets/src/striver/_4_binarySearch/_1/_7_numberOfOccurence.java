package striver._4_binarySearch._1;

public class _7_numberOfOccurence {
  public static int count(int[] arr, int n, int x) {
    int lowerBound, upperBound;
    if (n == 0) return 0;
    else {
      int L = 0, R = n, m;
      while (L < R) {
        m = (L + R) / 2;
        if (arr[m] < x) L = m + 1;
        else R = m;
      }
      if (L >= n || arr[L] != x) return 0;
      lowerBound = L;
      L = 0;
      R = n;
      while (L < R) {
        m = (L + R) / 2;
        if (arr[m] > x) R = m;
        else L = m + 1;
      }
      upperBound = R - 1;
    }
    return upperBound - lowerBound + 1;
  }
}
