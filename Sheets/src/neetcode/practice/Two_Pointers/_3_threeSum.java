package neetcode.practice.Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3_threeSum {
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) break; // Would end up repeating triplets in another order only
      if (i > 0 && nums[i] == nums[i - 1]) continue; // Don't retry for the same number

      int l = i + 1, r = n - 1;

      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum > 0) r--;
        else if (sum < 0) l++;
        else {
          ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
          l++;
          r--;
          // As the array is sorted, you could end up with the exact same nums[l] (or nums[r]), and
          // because nums[i] would not change, you'd get the same pair
          while (l < r && nums[l] == nums[l - 1]) l++;
          while (l < r && nums[r] == nums[r + 1]) r--;
        }
      }
    }

    return ans;
  }
}
