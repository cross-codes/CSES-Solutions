package striver._3_arrays._2;

public class _3_majorityElement {
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

  public static int majorityElement(int[] nums) {
    int n = nums.length;
    shellsort(nums, n);
    int targetFrequency = (int) Math.ceil(n / 2.0);
    int currElement = Integer.MAX_VALUE, currFrequency = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] != currElement) {
        if (currFrequency >= targetFrequency) return currElement;
        currElement = nums[i];
        currFrequency++;
      } else if (nums[i] == currElement) currFrequency++;
    }
    if (currFrequency >= targetFrequency) return currElement;
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1};
    System.out.println(majorityElement(arr));
  }
}
