package striver._4_binarySearch._1;

/**
 *
 *
 * <pre>
 * Logarithmic search
 *
 * In the worst case, the binary search takes O(log n) time It is faster than a linear search,
 * except on small arrays
 *
 * Procedure: Given an array A of n elements
 * A_0, A_1, ..., A_n SORTED such that A_0 <= A_1 <=
 * A_2 ..., and a target value T:
 *
 * (1) Set L to 0 and R to n - 1
 * (2) While L != R:
 *   (i) Set m to the ceiling of (L+R)/2
 *   (ii) If A_m > T set R to m - 1
 *   (iii) Else, A_m <= T ; set L to m
 * (3) Now L = R ; if A_L = T, return it, else -1.
 * </pre>
 */
public class _1_binarySearch {
  public static int search(int[] nums, int T) {
    int n = nums.length;
    int L = 0, R = n - 1, m;
    while (L != R) {
      if ((L + R) % 2 != 0) m = (L + R) / 2 + 1;
      else m = (L + R) / 2;

      if (nums[m] > T) R = m - 1;
      else L = m;
    }
    if (nums[L] == T) return L;
    else return -1;
  }
}
