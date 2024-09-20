package neetcode.practice.Two_Pointers;

public class _2_twoSumII {
  public static int[] twoSum(int[] numbers, int target) {
    int n = numbers.length;
    int idx1 = 0, idx2 = n - 1;

    while (true) {
      if (numbers[idx1] + numbers[idx2] > target) idx2--;
      else if (numbers[idx1] + numbers[idx2] < target) idx1++;
      else {
        return new int[] {Math.min(idx1, idx2) + 1, Math.max(idx1, idx2) + 1};
      }
    }
  }
}
