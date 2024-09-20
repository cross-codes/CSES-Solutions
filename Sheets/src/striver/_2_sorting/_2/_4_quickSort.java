package striver._2_sorting._2;

// Quick sort: Algorithm
// Choose a 'pivot' element and place it in the position
// it would be in, in the final sorted array.
// Shift any elements smaller than the pivot element to its
// left and any greater than it to its right. Repeat the
// process for the two subarrays partitioned by the pivot
//
// How to place the pivot?
// To do so, make a placer() function, after choosing the pivot
// Run two idx i and j from either ends. 'i' finds the first
// element that is greater than the pivot and stops,
// while j finds the smallest element that is smaller than
// the pivot and stops. If i < j, swap these, and proceed
// Continue till j <= i ; j now is the correct index for the pivot

public class _4_quickSort {
  public static void swap(int[] arr, int idx1, int idx2) {
    int temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }

  public static int placer(int[] arr, int low, int high) {
    int pivot = arr[low], i = low, j = high;

    while (i < j) {
      while (arr[i] <= pivot && i <= high - 1) i++;
      while (arr[j] > pivot && j >= low + 1) j--;
      if (i < j) swap(arr, i, j);
    }

    swap(arr, low, j);
    return j;
  }

  public static void quickSort(int[] input, int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      int pivotIndex = placer(input, startIndex, endIndex);

      quickSort(input, startIndex, pivotIndex - 1);
      quickSort(input, pivotIndex + 1, endIndex);
    }
  }
}
