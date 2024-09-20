package striver._5_strings._1;

public class _6_rotateString {
  public static boolean rotateString(String s, String goal) {
    int n = s.length();
    if (n != goal.length()) return false;
    else {
      StringBuilder test = new StringBuilder(s);
      for (int count = 0; count < n; count++) {
        test.append(test.toString().charAt(0));
        test.deleteCharAt(0);
        if (test.toString().equals(goal)) return true;
      }
    }
    return false;
  }
}
