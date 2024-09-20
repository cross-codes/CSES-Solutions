package striver._3_arrays._2;

public class _1_2Sum {
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

  public static int[] twoSum(int[] nums, int target) {
    int length = nums.length;
    int[] copy = new int[length];
    System.arraycopy(nums, 0, copy, 0, length);
    shellsort(nums, length);
    int left = 0, right = length - 1, sum = 0;
    int[] sortedIdx = new int[2], unsortedIdx = new int[2];
    while (left < right) {
      sum = nums[left] + nums[right];
      if (sum < target) left++;
      else if (sum > target) right--;
      else {
        sortedIdx[0] = left;
        sortedIdx[1] = right;
        break;
      }
    }
    boolean check1 = false, check2 = false;
    for (int i = 0; i < length; i++) {
      if (check1 && check2) break;
      if (!check1 && (copy[i] == nums[sortedIdx[0]])) {
        unsortedIdx[0] = i;
        check1 = true;
      } else if (!check2 && (copy[i] == nums[sortedIdx[1]])) {
        unsortedIdx[1] = i;
        check2 = true;
      }
    }
    return unsortedIdx;
  }

  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    int target = 9;
    int[] ans = twoSum(arr, target);
    for (int i = 0; i < 2; i++) {
      System.out.println(ans[i]);
    }
  }
}
