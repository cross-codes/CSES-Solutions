package striver._9_stacksAndQueues._3;

import java.util.Stack;

public class _2_nextGreaterElement2 {
  public static int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    Stack<Integer> stk = new Stack<>();

    for (int i = 2 * n - 1; i > -1; i--) {
      int idx = i % n; // This allows us to iterate through nums twice
      while (!stk.isEmpty() && stk.peek() <= nums[idx]) stk.pop();
      if (i < n) {
        if (!stk.isEmpty()) ans[idx] = stk.peek();
        else ans[idx] = -1;
      }
      stk.push(nums[idx]);
    }

    return ans;
  }
}
