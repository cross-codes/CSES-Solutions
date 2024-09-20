package striver._1_basics._4;

public class _1_numberOfDigits {
  public static int countDigits(int n) {
    return (n == 0) ? 1 : (int) Math.floor(Math.log10(n)) + 1;
  }
}
