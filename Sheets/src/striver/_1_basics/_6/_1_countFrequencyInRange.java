package striver._1_basics._6;

import java.util.HashMap;

// You are given an array 'arr' of length
// 'n' containing integers within the range '1' to 'x'.
// Your task is to count the frequency of all elements
// from 1 to n.

public class _1_countFrequencyInRange {
  public static int[] countFrequency(int n, int x, int[] nums) {
    // Create an Integer -> Integer hashmap
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      // Obtain the frequency corresponding to nums[i]
      int value = map.getOrDefault(nums[i], 0);
      // Increment this value
      map.put(nums[i], ++value);
    }

    int[] arr = new int[n];
    for (int j = 1; j <= n; j++) if (map.containsKey(j)) arr[j - 1] = map.get(j);
    return arr;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 1, 9, 2, 7};
    int[] ans = countFrequency(6, 9, nums);
    for (int i = 0; i < ans.length; i++) System.out.println(ans[i]);
  }
}
