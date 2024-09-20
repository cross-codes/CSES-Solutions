package striver._3_arrays._2;

public class _10_longestSuccessiveElements {
  static void shellsort(int v[], int n) {
    int gap = -1, i = -1, j = -1, temp = -1;

    for (gap = n / 2; gap > 0; gap /= 2)
      for (i = gap; i < n; i++)
        for (j = i - gap; j >= 0 && v[j] > v[j + gap]; j -= gap) {
          temp = v[j];
          v[j] = v[j + gap];
          v[j + gap] = temp;
        }
  }

  public static int longestConsecutive(int[] arr) {
    if (arr.length == 0) return 0;
    int len = arr.length, maxLen = 1, currLen = 1;
    shellsort(arr, len);
    for (int idx = 1; idx < len; idx++) {
      if (arr[idx] == arr[idx - 1]) continue;
      if ((arr[idx] - arr[idx - 1]) == 1) currLen++;
      else {
        if (maxLen < currLen) maxLen = currLen;
        currLen = 1;
      }
    }
    if (maxLen < currLen) maxLen = currLen;
    return maxLen;
  }
}
