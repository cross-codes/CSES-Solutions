package striver._4_binarySearch._1;

public class _10_findMinimumInRotatedSortedArray {
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
  
  public static int findMin(int[] nums) {
    shellsort(nums, nums.length);
    return nums[0];
  }
}
