package striver._9_stacksAndQueues._3;

public class _5_trapRainWater {
  // What is going on?
  static int countCells(int[] arr, int maxHeight, boolean processEqualMaximums) {
    int possibleCells = 0, approvedCells = 0;
    for (int x : arr) {
      if (x < maxHeight) possibleCells += maxHeight - x;
      else if (x > maxHeight || processEqualMaximums) {
        maxHeight = x;
        approvedCells += possibleCells;
        possibleCells = 0;
      }
    }
    return approvedCells;
  }

  static void reverse(int[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      int temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }

  public static int trap(int[] height) {
    int sum1 = countCells(height, height[0], true);
    reverse(height, 0, height.length - 1);
    int sum2 = countCells(height, height[0], false);
    return sum1 + sum2;
  }
}
