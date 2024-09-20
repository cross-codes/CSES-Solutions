package striver._8_bitManipulation._1;

public class _4_checkIfPowerOf2 {
  public static boolean isPowerOfTwo(int n) {
    // All powers of 2 would be of the form n = 0b100000...
    // And corresponding n - 1 would be 0b01111....
    return (n > 0 && (n & n - 1) == 0);
  }
}
