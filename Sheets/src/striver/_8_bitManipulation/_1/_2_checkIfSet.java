package striver._8_bitManipulation._1;

public class _2_checkIfSet {
  public static boolean checkKthBit(int n, int k) {
    int mask = 1 << k;
    return ((n & mask) != 0);
  }
}
