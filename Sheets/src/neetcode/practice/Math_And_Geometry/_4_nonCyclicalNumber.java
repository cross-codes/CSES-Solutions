package neetcode.practice.Math_And_Geometry;

import java.util.HashSet;

public class _4_nonCyclicalNumber {
  public static boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    while (true) {
      if (set.contains(n)) return false;

      set.add(n);
      int[] digits = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
      int len = digits.length, res = 0;

      for (int i = 0; i < len; i++) res += Math.pow(digits[i], 2);
      if (res == 1) return true;

      n = res;
    }
  }
}
