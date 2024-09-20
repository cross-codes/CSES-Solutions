package striver._9_stacksAndQueues._3;

import java.util.Stack;

public class _6_sumOfSubarrayMinimums {
  public static int sumSubarrayMins(int[] arr) {
    // Initialize previous less element and next less element of each element in arr
    Stack<int[]> previousLess = new Stack<>();
    Stack<int[]> nextLess = new Stack<>();

    int n = arr.length;

    int[] leftDistance = new int[n];
    int[] rightDistance = new int[n];

    for (int i = 0; i < n; ++i) {
      // Use >= to deal with duplicates
      while (!previousLess.isEmpty() && previousLess.peek()[0] >= arr[i]) previousLess.pop();
      leftDistance[i] = previousLess.isEmpty() ? i + 1 : i - previousLess.peek()[1];
      previousLess.push(new int[] {arr[i], i});
    }

    for (int i = n - 1; i > -1; --i) {
      // Use > now?
      while (!nextLess.isEmpty() && nextLess.peek()[0] > arr[i]) nextLess.pop();
      rightDistance[i] = nextLess.isEmpty() ? n - i : nextLess.peek()[1] - i;
      nextLess.push(new int[] {arr[i], i});
    }

    int ans = 0;
    int mod = (int) 1e9 + 7;
    for (int i = 0; i < n; i++) {
      ans = (int) ((ans + (long) arr[i] * leftDistance[i] * rightDistance[i]) % mod);
    }

    return ans;
  }
}
