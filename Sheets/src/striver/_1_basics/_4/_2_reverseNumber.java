package striver._1_basics._4;

public class _2_reverseNumber {
  public static int reverse(int x) {
    boolean isNegative = x < 0;
    String number = Integer.toString(x);
    System.out.println(number);
    StringBuffer sbr = new StringBuffer(number);
    String answerString = sbr.reverse().toString();
    if (isNegative) {
      answerString = answerString.substring(0, answerString.length() - 1);
    }
    try {
      int ans = Integer.parseInt(answerString);
      return isNegative ? -1 * ans : ans;
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public static void main(String[] args) {
    reverse(1534236469);
  }
}
