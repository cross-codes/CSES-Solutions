package neetcode.practice.Math_And_Geometry;

public class _5_plusOne {
  public static int[] plusOne(int[] digits) {
    int n = digits.length;
    long num = 0;

    for (int i = 0; i < n; i++) num += Math.pow(10, n - i - 1) * digits[i];
    return String.valueOf(num + 1).chars().map(Character::getNumericValue).toArray();
  }
}
