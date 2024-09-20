package neetcode.practice.Two_Pointers;

public class _4_maxWaterContainer {
  public static int maxArea(int[] heights) {
    int max = 0, n = heights.length;
    int l = 0, r = n - 1;

    while (l < r) {
      int length = r - l;
      int height = Math.min(heights[l], heights[r]);
      max = Math.max(max, length * height);
      // Attempt to retain the maximum of two heights
      if (heights[l] > heights[r]) r--;
      else if (heights[l] < heights[r]) l++;
      else {
        // Choose the next best height
        if (heights[l + 1] > heights[r - 1]) l++;
        else r--;
      }
    }

    return max;
  }
}
