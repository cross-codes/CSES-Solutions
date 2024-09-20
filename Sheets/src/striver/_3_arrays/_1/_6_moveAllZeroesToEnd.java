package striver._3_arrays._1;

public class _6_moveAllZeroesToEnd {
  public static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  public static void moveZeroes(int[] nums) {
    int j = -1, length = nums.length;
    for (int i = 0; i < length; i++)
      if (nums[i] == 0) {
        j = i;
        break;
      }

    if (j == -1) return;

    for (int i = j + 1; i < length; i++)
      if (nums[i] != 0) {
        swap(nums, i, j);
        j++;
      }
  }
}
