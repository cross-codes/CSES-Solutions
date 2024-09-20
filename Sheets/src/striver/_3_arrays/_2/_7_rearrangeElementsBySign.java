package striver._3_arrays._2;

public class _7_rearrangeElementsBySign {
  public static int[] rearrangeArray(int[] nums) {
    int arrLen = nums.length;
    int[] ans = new int[arrLen];
    int[] neg = new int[arrLen / 2];
    // Collect all positive numbers followed by zeroes
    // In the same loop, collect all negative numbers in order
    for (int idx = 0, i = 0, j = 0; idx < arrLen; idx++) {
      int currNum = nums[idx];
      if (currNum > 0) {
        ans[i++] = currNum;
        ans[i++] = 0;
      } else neg[j++] = currNum;
    }

    // Replace in steps of 2
    for (int ridx = 1, j = 0; ridx < arrLen; ridx += 2, j++) ans[ridx] = neg[j];
    return ans;
  }
}
