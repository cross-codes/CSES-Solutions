package striver._4_binarySearch._1;

public class _9_searchInRotatedSortedArray2 {
 static void reverse(int[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      int temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }
  
  public static boolean search(int[] nums, int target) {
    int pivot_idx = -1, n = nums.length;
    // Find the pivot
    for (int idx = 1; idx < n; idx++) {
      if (nums[idx] < nums[idx - 1]) {
        pivot_idx = idx;
        break;
      }
    }

    if (pivot_idx != -1) {
      // Sort the array now
      reverse(nums, 0, pivot_idx - 1);
      reverse(nums, pivot_idx, n - 1);
      reverse(nums, 0, n - 1);
    }

    // Find the target

    int L = 0, R = n - 1, m;
    while (L != R) {
      if ((L + R) % 2 != 0) m = (L + R) / 2 + 1;
      else m = (L + R) / 2;

      if (nums[m] > target) R = m - 1;
      else L = m;
    }
    if (nums[L] == target) return true;
    else return false;
  }
}
