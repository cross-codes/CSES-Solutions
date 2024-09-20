package striver._2_sorting;

public class _shellSort {
  public static void shellsort(int v[], int n) {
    int gap = -1, i = -1, j = -1, temp = -1;

    for (gap = n / 2; gap > 0; gap /= 2)
      for (i = gap; i < n; i++)
        for (j = i - gap; j >= 0 && v[j] > v[j + gap]; j -= gap) {
          temp = v[j];
          v[j] = v[j + gap];
          v[j + gap] = temp;
        }
  }

  public static void main(String[] args) {
    int[] nums = {2, 1, 3, 4, 5, 9, 10};
    shellsort(nums, nums.length);
    for (int var : nums) {
      System.out.println(var);
    }
  }
}
