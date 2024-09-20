package striver._2_sorting._2;

// Merge sort: Algorithm
// Create two functions: merge(arr[], l, m, h)
// and mergeSort(arr, l, h)
// mergeSort is recursive in nature
// In every call, as long as l < h, the value of m is
// set to the average of l and h
// The function is recursively called for the left half, with
// h = m, and once done, the function is recursively called for
// for the right half with l = m + 1.
// The base case ensures that each of the iterations of recursion
// except the last one will proceed to the next step (right side)
// and the next step that is merge(arr[], l, m, h)the function is recursively called for
// for the right half with l = m + 1.
// The base case ensures that each of the iterations of recursion
// except the last one will proceed to the next step (right side)
// and the next step that is merge(arr[], l, m, h)
// The first calls of merge(arr[], l, m, h) occur when the passed
// arrays are of length 1 (which are sorted by definition)
//
// merge(...) creates a temporary array 'temp', and runs two varibles parallely
// from l to m and from m+1 to h. In each step, the corresponding elements of
// arr[] are compared, and the smaller element is added to temp.
// Only one of the two variables is incremented
// This process continues till one of the variables reach the exit condition
// Then, the remaining elements are appended to the array, and then
// the corresponding elements in arr[] are replaced by temp[]

public class _1_mergeSort {
  public static void merge(int[] arr, int l, int m, int h) {
    int[] temp = new int[h + 1];
    int left = l, right = m + 1, idx = 0;
    for (; left <= m && right <= h; idx++) {
      if (arr[left] <= arr[right]) {
        temp[idx] = arr[left];
        left++;
      } else {
        temp[idx] = arr[right];
        right++;
      }
    }

    for (; left <= m; left++, idx++) temp[idx] = arr[left];

    for (; right <= h; right++, idx++) temp[idx] = arr[right];

    for (int i = l; i <= h; i++) arr[i] = temp[i - l];
  }

  public static void mergeSort(int[] arr, int l, int h) {
    if (l >= h) return;

    int mid = (l + h) / 2;

    mergeSort(arr, l, mid);
    mergeSort(arr, mid + 1, h);
    merge(arr, l, mid, h);
  }
}
