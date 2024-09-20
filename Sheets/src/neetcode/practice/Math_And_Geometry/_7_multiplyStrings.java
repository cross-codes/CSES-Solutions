package neetcode.practice.Math_And_Geometry;

import java.math.BigInteger;

public class _7_multiplyStrings {
  public static String multiply(String num1, String num2) {
    BigInteger n1 = new BigInteger(num1);
    BigInteger n2 = new BigInteger(num2);
    return String.valueOf(n1.multiply(n2));
  }

  public static void main(String[] args) {
    System.out.println(multiply("1124", "1234"));
  }
}
