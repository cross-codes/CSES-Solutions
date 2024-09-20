package neetcode.practice.Greedy;

public class _3_jumpGameII {
  public static int jump(int[] nums) {
    int res = 0, leftBoundary = 0, rightBoundary = 0, n = nums.length;

    while (rightBoundary < n - 1) {
      int farthestIndex = 0;
      for (int i = leftBoundary; i <= rightBoundary; i++)
        farthestIndex = Math.max(farthestIndex, i + nums[i]);

      leftBoundary = rightBoundary + 1;
      rightBoundary = farthestIndex;
      res++;
    }

    return res;
  }
}
