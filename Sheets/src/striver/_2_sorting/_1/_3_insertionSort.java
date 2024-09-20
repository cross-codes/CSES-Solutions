package striver._2_sorting._1;

// Insertion sort: Algorithm
// Traverse the array from 1 to n, and store the current
// value as a 'test'.
// Next, traverse the array from i to 0. Should the
// value of an element be greater than test, replace
// the next index's element with this new element
// The 'test' value may be overriden this way
// Say this condition breaks at an index idx.
// Set the value at idx + 1 to test

public class _3_insertionSort {
  public static void insertionSort(int[] arr, int size) {
    int test = -1, idx = -1;
    for (int i = 1; i < size; i++) {
      test = arr[i];
      idx = i - 1;
      while (idx >= 0 && arr[idx] > test) {
        arr[idx + 1] = arr[idx];
        idx--;
      }
      arr[idx + 1] = test;
    }
  }
}
