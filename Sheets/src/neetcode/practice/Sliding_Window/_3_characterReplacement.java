package neetcode.practice.Sliding_Window;

public class _3_characterReplacement {
  public static int characterReplacement(String s, int k) {
    int ans = 0;
    int n = s.length();

    // Try to see if a substring of some substitution is possible
    for (char c = 'A'; c <= 'Z'; c++) {
      int i = 0, j = 0, replaced = 0;
      while (j < n) {
        if (s.charAt(j) == c) j++;
        else if (replaced < k) {
          j++;
          replaced++;
        } else if (s.charAt(i) == c) i++;
        else {
          i++;
          replaced--;
        }
        ans = Math.max(ans, j - i);
      }
    }

    return ans;
  }
}
