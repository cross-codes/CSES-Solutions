package striver._3_arrays._2;

public class _8_nextPermutation {
  static void reverse(int[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      int temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }

  static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  public static void nextPermutation(int[] nums) {
    // Step 1: Find the largest index idx such that nums[idx] < nums[idx+1]
    int len = nums.length, idx = len - 2;
    for (; idx >= 0; idx--) if (nums[idx] < nums[idx + 1]) break;

    // If no such index exists, this is the largest possible permutation
    // Simply reverse the array in this case to get the next permutation (smallest)
    if (idx < 0) reverse(nums, 0, len - 1);
    else {
      // Step 2: Find the largest index lidx > idx such that nums[idx] < nums[lidx]
      int lidx = len - 1;
      for (; lidx > idx; lidx--) if (nums[lidx] > nums[idx]) break;
      // Step 3: Swap these numbers and reverse the subarray nums[k+1:]:
      swap(nums, idx, lidx);
      reverse(nums, idx + 1, len - 1);
    }
  }
}
