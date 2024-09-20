package neetcode.practice.Two_Pointers;

public class _5_trapRainWater {
  public static int trap(int[] height) {
    if (height == null || height.length == 0) return 0;

    int n = height.length;
    int l = 0, r = n - 1;

    int leftMaxHeight = height[l], rightMaxHeight = height[r];
    int ans = 0;

    while (l < r) {
      if (leftMaxHeight < rightMaxHeight) {
        l++;
        leftMaxHeight = Math.max(leftMaxHeight, height[l]);
        ans += leftMaxHeight - height[l]; // Would be no change if this was a new maximum
      } else {
        r--;
        rightMaxHeight = Math.max(rightMaxHeight, height[r]);
        ans += rightMaxHeight - height[r]; // Would be no change if this was a new maximum
      }
    }

    return ans;
  }
}
