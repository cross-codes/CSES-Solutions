package striver._5_strings._2;

public class _4_atoi {
  public static int myAtoi(String s) {
    s = s.trim();
    int ans = 0, digit = 0, n = s.length();
    if (n == 0) return 0;

    char start = s.charAt(0);
    boolean isNegative = start == '-' ? true : false;
    boolean symbolAtStart = (isNegative || start == '+');
    int N = (symbolAtStart) ? 1 : 0;

    for (int count = 0; count < n; count++) {
      char c = s.charAt(count);
      if ((c == '-' || c == '+') && count == 0) continue;
      else if ((int) c < 48 || (int) c > 57) break;
      N++;
    }

    for (int idx = N - 1; idx > -1; idx--, digit++) {
      try {
        char c = s.charAt(idx);
        if (c == '-' || c == '+') continue;
        ans = Math.addExact(ans, Math.multiplyExact((int) (c - 48), (int) Math.pow(10, digit)));
      } catch (ArithmeticException e) {
        if (isNegative) return Integer.MIN_VALUE;
        else return Integer.MAX_VALUE;
      }
    }
    return (isNegative) ? -ans : ans;
  }
}
