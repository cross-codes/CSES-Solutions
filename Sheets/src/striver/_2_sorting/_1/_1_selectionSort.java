package striver._2_sorting._1;

// Selection sort: Algorithm
// Traverse the array from index i to n, and swap
// the minimum element with the element at index i
// Increment i by one and continue. Start i from 0

public class _1_selectionSort {
  public static void selectionSort(int[] arr) {
    int arrayLength = arr.length,
        minValue = Integer.MAX_VALUE,
        minIndex = -1,
        temp = Integer.MIN_VALUE;
    for (int i = 0; i < arrayLength; i++) {
      minValue = Integer.MAX_VALUE;
      minIndex = -1;
      for (int j = i; j < arrayLength; j++) {
        if (arr[j] < minValue) {
          minValue = arr[j];
          minIndex = j;
        }
      }
      temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
  }
}
