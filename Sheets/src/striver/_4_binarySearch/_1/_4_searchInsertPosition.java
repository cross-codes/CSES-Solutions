package striver._4_binarySearch._1;

public class _4_searchInsertPosition {
  public static int searchInsert(int[] nums, int target) {
    int n = nums.length, L = 0, R = n - 1, m;
    while (L != R) {
      if ((L + R) % 2 != 0) m = (L + R) / 2 + 1;
      else m = (L + R) / 2;

      if (nums[m] > target) R = m - 1;
      else L = m;
    }
    if (nums[L] >= target) return L;
    else {
      if (nums[L] < target) return L + 1;
    }
    return 0;
  }
}
