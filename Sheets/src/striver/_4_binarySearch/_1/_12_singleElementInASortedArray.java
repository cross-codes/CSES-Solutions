package striver._4_binarySearch._1;

public class _12_singleElementInASortedArray {
  public static int singleNonDuplicate(int[] nums) {
    int n = nums.length;
    if (n == 1) return nums[0];
    if (nums[0] != nums[1]) return nums[0];
    if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

    int L = 1, R = n - 2, m = 0;
    while (L != R) {
      m = (L + R) / 2;

      // Check if A_m is the single element;
      if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) return nums[m];

      // To choose which halves to eliminate, deduce where you are
      // Left halves have (even, odd) equal indexes.
      // Right halves have (odd, even) equal indexes.
      if ((m % 2 == 0 && nums[m] == nums[m + 1]) || (m % 2 == 1 && nums[m] == nums[m - 1]))
        L = m + 1;
      else R = m - 1;
    }
    return nums[L];
  }
}
