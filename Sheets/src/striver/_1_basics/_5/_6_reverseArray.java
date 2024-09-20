package striver._1_basics._5;

public class _6_reverseArray {
  public static void reverse(int[] arr, int idxRange) {
    int temp;
    for (int i = 0; i < idxRange / 2; i++) {
      temp = arr[i];
      arr[i] = arr[idxRange - i - 1];
      arr[idxRange - i - 1] = temp;
    }
  }

  public static int[] reverseArray(int n, int[] nums) {
    reverse(nums, n);
    return nums;
  }
}
