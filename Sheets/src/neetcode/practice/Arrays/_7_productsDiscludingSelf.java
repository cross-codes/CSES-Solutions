package neetcode.practice.Arrays;

public class _7_productsDiscludingSelf {
  public static int[] productExceptSelf(int[] nums) {
    int zeroCount = 0, n = nums.length;
    int firstZeroIndex = -1;
    int product = 1;
    for (int i = 0; i < n; i++) {
      if (zeroCount > 1) return new int[n];
      else {
        if (nums[i] == 0) {
          zeroCount++;
          firstZeroIndex = i;
        } else product *= nums[i];
      }
    }

    int[] ans = new int[n];
    if (zeroCount > 0 && zeroCount <= 1) ans[firstZeroIndex] = product;
    else if (zeroCount < 2) {
      for (int i = 0; i < n; i++) {
        ans[i] = product / nums[i];
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {1, 20, 0, 0};
    System.out.println(productExceptSelf(arr));
  }
}
