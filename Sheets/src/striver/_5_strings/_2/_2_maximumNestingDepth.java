package striver._5_strings._2;

public class _2_maximumNestingDepth {
  public static int maxDepth(String s) {
    int n = s.length();
    int currDepth = 0, ans = 0;
    for (int idx = 0; idx < n; idx++) {
      char c = s.charAt(idx);
      if (c != '(' && c != ')') continue;
      else if (c == '(') {
        currDepth++;
      } else {
        if (ans < currDepth) ans = currDepth;
        currDepth--;
      }
    }
    return ans;
  }
}
