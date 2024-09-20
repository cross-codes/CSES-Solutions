package neetcode.practice.Bit_Manipulation;

public class _6_sumOfTwoIntegers {
  public static int getSum(int a, int b) {
    while (b != 0) {
      int temp = (a & b) << 1;
      a = a ^ b;
      b = temp;
    }

    return a;
  }
}
