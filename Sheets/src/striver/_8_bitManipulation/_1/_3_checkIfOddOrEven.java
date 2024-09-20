package striver._8_bitManipulation._1;

public class _3_checkIfOddOrEven {
  public static String oddEven(int N) {
    if ((N & 1) != 0) {
      return "odd";
    } else {
      return "even";
    }
  }
}
