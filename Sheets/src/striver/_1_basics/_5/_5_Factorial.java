package striver._1_basics._5;

import java.util.ArrayList;
import java.util.List;

public class _5_Factorial {
  public static long factorial(long n) {
    if (n == 1 || n == 0) return 1;
    return n * factorial(n - 1);
  }

  public static List<Long> factorialNumbers(long n) {
    List<Long> ans = new ArrayList<>();
    long idx = 1;
    long factorial = -1;
    while (true) {
      factorial = factorial(idx);
      if (factorial <= n) {
        ans.add(factorial);
        idx++;
      } else break;
    }

    return ans;
  }
}
