package neetcode.practice.Two_Pointers;

public class _1_isPalindrome {
  public static boolean isPalindrome(String s) {
    s = s.replaceAll("[^a-zA-Z0-9]", "");
    int n = s.length();
    if (n == 0) return true;

    for (int i = 0; i < n / 2 + 1; i++) {
      char forward = s.charAt(i), backward = s.charAt(n - i - 1);
      if (Character.toLowerCase(forward) != Character.toLowerCase(backward)) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("0P"));
  }
}
