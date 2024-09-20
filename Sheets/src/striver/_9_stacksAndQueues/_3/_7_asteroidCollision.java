package striver._9_stacksAndQueues._3;

import java.util.Stack;

public class _7_asteroidCollision {
  public static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stk = new Stack<Integer>();
    int n = asteroids.length;
    for (int i = 0; i < n; i++) {
      if (asteroids[i] > 0 || stk.isEmpty()) stk.push(asteroids[i]);
      else {
        // A negative asteroid is encountered and the stack is nonempty
        // While the stack is nonempty, the top is positive and lesser than the new asteroid's
        // positive value
        // Keep popping the stack
        while (!stk.isEmpty() && stk.peek() > 0 && stk.peek() < -asteroids[i]) stk.pop();
        // If the stack is empty, or the top is negative, add the new asteroid
        if (stk.isEmpty() || stk.peek() < 0) stk.push(asteroids[i]);
        // Else, the stack is nonempty and the top is exactly the negative of this asteroid ;
        // annihilation
        else if (stk.peek() == -asteroids[i]) stk.pop();
      }
    }
    n = stk.size();
    int[] ans = new int[n];
    for (int idx = n - 1; idx > -1; idx--) {
      ans[idx] = stk.pop();
    }

    return ans;
  }
}
