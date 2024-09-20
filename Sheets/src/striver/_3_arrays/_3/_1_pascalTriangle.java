package striver._3_arrays._3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _1_pascalTriangle {
  static BigInteger factorial(int n) {
    BigInteger ans = BigInteger.ONE;
    if (n == 0) return ans;
    for (int i = 1; i <= n; i++) ans = ans.multiply(BigInteger.valueOf(i));
    return ans;
  }

  static int nCr(int n, int r) {
    return (factorial(n).divide(factorial(n - r).multiply(factorial(r)))).intValue();
  }

  static List<Integer> generateRow(int rowNum) {
    ArrayList<Integer> pascalRow = new ArrayList<>();
    for (int i = 0; i <= rowNum; i++) pascalRow.add(nCr(rowNum, i));
    return pascalRow;
  }

  public static List<List<Integer>> generate(int numRows) {
    // The elements of a row of pascal's triangle are combinatorics
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < numRows; i++) ans.add(generateRow(i));
    return ans;
  }
}
