package striver._5_strings._2;

public class _6_longestPalindromicSubstring {
  static String expandFromCenter(String s, int leftIdx, int rightIdx) {
    while (leftIdx >= 0 && rightIdx < s.length() && s.charAt(leftIdx) == s.charAt(rightIdx)) {
      leftIdx--;
      rightIdx++;
    }

    // Don't include left index and right index
    return s.substring(leftIdx + 1, rightIdx);
  }

  public static String longestPalindrome(String s) {
    int n = s.length();
    if (n <= 1) return s;

    String ans = s.substring(0, 1); // s[0]

    for (int idx = 0; idx < n - 1; idx++) {
      String odd = expandFromCenter(s, idx, idx);
      String even = expandFromCenter(s, idx, idx + 1);

      if (odd.length() > ans.length()) ans = odd;
      if (even.length() > ans.length()) ans = even;
    }

    return ans;
  }
}
