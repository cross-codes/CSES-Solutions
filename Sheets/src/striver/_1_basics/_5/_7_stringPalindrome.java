package striver._1_basics._5;

import java.util.Arrays;

public class _7_stringPalindrome {
  public static void reverse(char[] arr, int idxRange) {
    char temp;
    for (int i = 0; i < idxRange / 2; i++) {
      temp = arr[i];
      arr[i] = arr[idxRange - i - 1];
      arr[idxRange - i - 1] = temp;
    }
  }

  public static boolean isPalindromeBad(String s) {
    char[] chars = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
    char[] revChars = Arrays.copyOf(chars, chars.length);
    reverse(revChars, chars.length);
    return Arrays.equals(chars, revChars);
  }
}
