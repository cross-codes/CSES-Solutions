package neetcode.practice.Binary_Search;

public class _1_binarySearch {
  public static int search(int[] nums, int target) {
    int n = nums.length;

    int l = 0, r = n - 1;

    while (l <= r) {
      int m = (l + r) / 2;
      if (nums[m] < target) l = m + 1;
      else if (nums[m] > target) r = m - 1;
      else return m;
    }

    return -1;
  }
}
