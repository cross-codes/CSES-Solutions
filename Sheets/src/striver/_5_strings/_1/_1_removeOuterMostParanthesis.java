package striver._5_strings._1;

public class _1_removeOuterMostParanthesis {
  public static String removeOuterParentheses(String s) {
    StringBuilder ans = new StringBuilder();
    int count = 0, n = s.length();

    // Iterate through each character of the parameter
    for (int idx = 0; idx < n; idx++) {
      if (s.charAt(idx) == '(') {
        // It will be an outer bracket only if count is zero
        // We put the condition first because "(" occurs first.
        if (count > 0) ans.append(Character.toString(s.charAt(idx)));
        count++;
      } else {
        // If a closing bracket, then lower the count
        // It will be an outer bracket only if count is zero
        count--;
        if (count > 0) ans.append(Character.toString(s.charAt(idx)));
      }
    }
    return ans.toString();
  }
}
