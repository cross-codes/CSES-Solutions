package striver._8_bitManipulation._3;

public class _3_countPrimes {
  public static int countPrimes(int n) {
    boolean[] notPrime = new boolean[n];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (notPrime[i] == false) {
        count++;
        for (int j = 2; i * j < n; j++) {
          // Mark multiples in this range as excluded
          notPrime[i * j] = true;
        }
      }
    }

    return count;
  }
}
