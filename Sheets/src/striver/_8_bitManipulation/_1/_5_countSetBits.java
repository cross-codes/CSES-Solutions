package striver._8_bitManipulation._1;

import java.util.HashMap;
import java.util.Map;

public class _5_countSetBits {
  // Brian Kernighan's algorithm:
  // Subtracting 1 from a decimal number flips all the
  // bits after the rightmost set bit including it

  private static Map<Integer, Integer> memo = new HashMap<>();

  static int numberOfSetBits(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1);
      count++;
    }

    return count;
  }

  public static int countSetBits(int n) {
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (!memo.containsKey(i)) memo.put(i, numberOfSetBits(i));
      ans += memo.get(i);
    }

    return ans;
  }
}
