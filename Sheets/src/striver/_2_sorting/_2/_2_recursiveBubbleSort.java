package striver._2_sorting._2;

// Recursive bubble sort: Algorithm
// The tenet is the same, except that the outer loop
// is discarded and replaced by recursive calls

public class _2_recursiveBubbleSort {
  public static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  public static void bubbleSort(int[] arr, int n) {
    if (n == 0) return;
    for (int j = 0; j < n - 1; j++) {
      if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
    }
    bubbleSort(arr, n - 1);
  }
}
