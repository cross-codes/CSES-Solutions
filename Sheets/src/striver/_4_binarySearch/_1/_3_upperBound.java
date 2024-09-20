package striver._4_binarySearch._1;

/**
 * <pre>
 * The only difference with this problem statement, is that
 * we need the smallest index in a sorted array, where the target
 * is strictly greater than it
 *
 * It is easy to see how we would make a small modification here:
 * <pre>
 */
public class _3_upperBound {
  public static int upperBound(int[] nums, int x) {
    int n = nums.length, L = 0, R = n - 1, m = -1;
    while (L != R) {
      if ((L + R) % 2 != 0) m = (L + R) / 2 + 1;
      else m = (L + R) / 2;

      if (nums[m] > x) R = m - 1;
      else L = m;
    }

    for (; L > 0; L--) if (nums[L] <= x) {
      if (nums[L] == x) return L + 2;
      else return L + 1;
    };
    return n;
  }
}
