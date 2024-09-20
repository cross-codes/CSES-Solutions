package striver._4_binarySearch._1;

public class _11_findHowManyRotations {
  public static int findKRotation(int[] arr, int n) {
    int L = 0, R = n - 1, ans = Integer.MAX_VALUE;
    int idx = -1;
    while (L <= R) {
      int m = (L + R) / 2;
      // Break condition apart from L <= R
      // This should usually not happen unless both
      // pointers are in a sorted part of the array.
      if (arr[L] <= arr[R]) {
        if (arr[L] < ans) {
          idx = L;
          ans = arr[L];
        }
        break;
      }

      // If the left part is sorted
      // Here, if it is even lesser than the older
      // set value of ans, we may potentially have the
      // answer.
      if (arr[L] <= arr[m]) {
        if (arr[L] < ans) {
          idx = L;
          ans = arr[L];
        }
        // Eliminate the left half
        L = m + 1;
      } else {
        // If the right part is sorted
        if (arr[m] < ans) {
          idx = m;
          ans = arr[m];
        }
        // Eliminate the right half
        R = m - 1;
      }
    }
    return idx;
  }
}
