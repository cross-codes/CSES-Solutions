package striver._8_bitManipulation._2;

public class _4_XORnumbers {
  // XOR all elements in [0, n]
  static int XORupto(int n) {
    int rem = n % 4;
    if (rem == 0) return n;
    if (rem == 1) return 1;
    if (rem == 2) return n + 1;
    else return 0;
  }

  public static int findXOR(int l, int r) {
    return XORupto(l - 1) ^ XORupto(r);
    // This will be 0 ^ 1 ^ 2 ^ ... ^ l - 1 ^ 0 ^ 1 ^ 2 ^ ... ^ r
    // Which rearranges to (0 ^ 0) ^ (1 ^ 1) ^ (2 ^ 2) ...
    // (l - 1) ^ (l - 1) ^ (l ^ l + 1 ^ l + 2 .... ^ r)
    // = 0 ^ (l ^ l + 1 ^ l + 2 ... ^ r)
    // = l ^ l + 1 ^ l + 2 ... ^ r
  }
}
