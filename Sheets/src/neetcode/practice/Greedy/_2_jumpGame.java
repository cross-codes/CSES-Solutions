package neetcode.practice.Greedy;

public class _2_jumpGame {
  public static boolean canJump(int[] nums) {
    int n = nums.length, goal = n - 1;

    for (int idx = n - 1; idx >= 0; idx--) {
      if (nums[idx] + idx >= goal) goal = idx;
    }

    return goal == 0;
  }
}
