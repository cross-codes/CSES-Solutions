package striver._5_strings._1;

public class _3_largestOddNumber {
  public static String largestOddNumber(String num) {
    int len = num.length();
    for (int idx = len - 1; idx >= 0; idx--)
      if (Integer.valueOf(num.charAt(idx)) % 2 != 0) return num.substring(0, idx + 1);
    return "";
  }
}
