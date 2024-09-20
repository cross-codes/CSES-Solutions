package striver._3_arrays._3;

import java.util.ArrayList;
import java.util.List;

public class _2_majorityElement {
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

  public static List<Integer> majorityElement(int[] nums) {
    int len = nums.length;
    shellsort(nums, len);
    int curNum = nums[0], count = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      if (nums[i] != curNum) {
        if (count > len / 3) ans.add(curNum);
        curNum = nums[i];
        count = 1;
      } else count++;
    }
    if (count > len / 3) ans.add(curNum);
    return ans;
  }
}
