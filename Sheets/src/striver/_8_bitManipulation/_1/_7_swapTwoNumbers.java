package striver._8_bitManipulation._1;

import java.util.ArrayList;
import java.util.List;

public class _7_swapTwoNumbers {
  public static List<Integer> get(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    List<Integer> ans = new ArrayList<>();
    ans.add(a);
    ans.add(b);
    return ans;

    // Logic:
    // XOR returns 0 if the corresponding bits are the same
    // Say we have these equivalent assignments:
    // x1 = x ^ y
    // y1 = x1 ^ y
    // x2 = x1 ^ y1
    // Then:
    // x2 = x1 ^ (x1 ^ y)
    // x2 = (x1 ^ x1) ^ y
    // x2 = 0 ^ y = y
    // Whereas:
    // y1 = (x ^ y) ^ y
    // y1 = x ^ (y ^ y)
    // y1 = x ^ 0 = x
  }
}
