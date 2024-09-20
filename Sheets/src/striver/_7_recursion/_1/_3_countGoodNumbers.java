package striver._7_recursion._1;

import java.math.BigInteger;

public class _3_countGoodNumbers {
  public static int countGoodNumbers(long n) {
    long evenPositions = 0, oddPositions = 0;
    if ((n & 1) == 1) {
      evenPositions = (n - 1) / 2 + 1;
      oddPositions = n - evenPositions;
    } else {
      evenPositions = (n - 2) / 2 + 1;
      oddPositions = n - evenPositions;
    }

    BigInteger ans =
        BigInteger.valueOf(4)
            .modPow(BigInteger.valueOf(oddPositions), BigInteger.valueOf(1000000007))
            .multiply(
                BigInteger.valueOf(5)
                    .modPow(BigInteger.valueOf(evenPositions), BigInteger.valueOf(1000000007)));
    ans = ans.remainder(BigInteger.valueOf(1000000007));

    return ans.intValue();
  }
}
