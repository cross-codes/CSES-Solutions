package striver._2_sorting._2;

// Recursive insertion sort: Algorithm
// The tenet is the same, except the outer loop
// is discarded and replaced by recursive calls

public class _3_recursiveInsertionSort {
  public static void insertionSort(int[] arr, int size) {
    if (size == 1) return;
    int i = arr.length - size + 1;
    int test = arr[i], idx = i - 1;
    while (idx >= 0 && arr[idx] > test) {
      arr[idx + 1] = arr[idx];
      idx--;
    }
    arr[idx + 1] = test;
    insertionSort(arr, size - 1);
  }
}
