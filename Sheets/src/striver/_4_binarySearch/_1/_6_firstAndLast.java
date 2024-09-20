package striver._4_binarySearch._1;

/**
 *
 *
 * <pre>
 * Procedure for finding the leftmost element:
 * (1) Set L to 0 and R to n
 * (2) While L < R
 *    (i) Set m to the floor of (L + R) / 2
 *    (ii) If A_m < T set L to m + 1
 *    (iii) Else, A_m >= T ; set R to m
 * (3) Return L
 * </pre>
 */
public class _6_firstAndLast {
  public static int[] searchRange(int[] nums, int target) {
    int ans[] = new int[2];
    int len = nums.length;
    int L = 0, R = len, m;
    if (len == 0) {
      ans[0] = -1;
      ans[1] = -1;
    } else {
      while (L < R) {
        m = (L + R) / 2;
        if (nums[m] < target) L = m + 1;
        else R = m;
      }
      if (L >= len || nums[L] != target) {
        ans[0] = -1;
        ans[1] = -1;
      } else {
        ans[0] = L;
        for (int idx = L; idx < len; idx++) {
          if (nums[idx] != target) {
            ans[1] = idx - 1;
            break;
          }
          ans[1] = idx;
        }
      }
    }
    return ans;
  }
}
