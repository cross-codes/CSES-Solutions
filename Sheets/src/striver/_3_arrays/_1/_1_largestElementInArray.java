package striver._3_arrays._1;

public class _1_largestElementInArray {
  public static int largestElement(int[] arr, int n) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) max = arr[i];
    }
    return max;
  }
}
