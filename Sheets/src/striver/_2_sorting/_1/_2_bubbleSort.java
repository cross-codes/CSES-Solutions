package striver._2_sorting._1;

// Bubble sort: Algorithm
// Maintain an index i that traverses the array backwards
// Maintain a second index that ranges from 0 to i - 1
// Swap adjacent elements until the maximum element reaches the end

public class _2_bubbleSort {
  public static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  public static void bubbleSort(int[] arr, int n) {
    for (int i = n - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
      }
    }
  }
}
