package striver._8_bitManipulation._1;

public class _6_setRightMostUnsetBit {
  public static int setBit(int n) {
    int count = 0;
    int k = 1;
    while ((n & k) != 0) {
      k = 1 << count;
      count++;
    }
    return n | k;
  }
}
